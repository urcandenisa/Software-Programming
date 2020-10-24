using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;
using core;
using core.Models;
using server.RequestHandler;

namespace server
{
    public class MessageHandler : IMessageHandler
    {
        private BaseHandler baseHandler;
        private AdminHandler adminHandler;
        private UserHandler userHandler;
        public MessageHandler(BaseHandler baseHandler = null, AdminHandler adminHandler = null, UserHandler userHandler= null)
        {
            this.baseHandler = baseHandler ?? new BaseHandler();
            this.adminHandler = adminHandler ?? new AdminHandler();
            this.userHandler = userHandler ?? new UserHandler();
        }

        public Message handleAsync(Message msgReceived)
        {
            Message msgToSend = new Message();

            switch (msgReceived.messageType)
            {
                case MessageType.UPDATE_RATING:
                    {
                        int index = msgReceived.Content.IndexOf(' ');
                        String ratingNumber = msgReceived.Content.Substring(0, index);
                        String activityName = msgReceived.Content.Substring(index+1);
                        Activity activity = baseHandler.filterByName(activityName);
                        int.TryParse(ratingNumber, out int number);
                        String activityNewRatingNumber = ((number + activity.rate) / 2).ToString();
                        adminHandler.updateActivity(activity.name, activity.type, activity.hours, activity.location, activity.available.ToString(), activity.maxNumber.ToString(), activity.pricePerPerson.ToString(), activityNewRatingNumber);
                        msgToSend.Content = msgReceived.Content;

                        msgToSend.activityContent = activity;
                        msgToSend.messageType = MessageType.UPDATE_RATING;
                        break;
                    }
                case MessageType.HANDLE_ACTIVITIES_NAME:
                    {
                        String activityName = msgReceived.Content;
                        Activity activity = baseHandler.filterByName(activityName);
                        msgToSend.Content = msgReceived.Content;
                        msgToSend.activityContent = activity;
                        msgToSend.messageType = MessageType.HANDLE_ACTIVITIES_NAME;
                        break;
                    }
                case MessageType.UNREGISTER:
                    {
                        int index = 0;
                        if (msgReceived.Content.Contains(' '))
                        {
                            index = msgReceived.Content.IndexOf(' ');
                        }
                        String username = msgReceived.Content.Substring(0, index);
                        String activityName = msgReceived.Content.Substring(index + 1);
                        User user = baseHandler.filterByUsername(username);
                        if (user == null) user = baseHandler.filterByEmail(username);
                        Activity activity = baseHandler.filterByName(activityName);
                        List<Report> reports = baseHandler.findByUserID(user.ID);
                        foreach (Report report in reports)
                        {
                            baseHandler.delete(report);
                        }
                        List<Observer> observers = baseHandler.findObsByUserID(user.ID);
                        foreach (Observer observer in observers)
                        {
                            baseHandler.delete(observer);
                        }
                        
                        msgToSend.Content = msgReceived.Content;
                        

                        msgToSend.messageType = MessageType.UNREGISTER;
                        break;
                    }
                case MessageType.VIEW_REGISTRATIONS:
                    {
                        User user = baseHandler.filterByUsername(msgReceived.Content);
                        if (user == null) user = baseHandler.filterByEmail(msgReceived.Content);

                        var result = baseHandler.getAllObservers();
                        List<Activity> activities = new List<Activity>();
                        foreach (var group in result)
                        {
                            if(group.IDU == user.ID)
                            {
                                Activity activity = baseHandler.findById(group.IDA);
                                activities.Add(activity);
                            }

                        }
                        msgToSend.Content = msgReceived.Content;
                        msgToSend.activities = activities;
                        msgToSend.messageType = MessageType.VIEW_REGISTRATIONS;
                        break;
                    }
                case MessageType.REGISTER:
                    {
                        int index = 0;
                        if (msgReceived.Content.Contains(' '))
                        {
                            index = msgReceived.Content.IndexOf(' ');
                        }
                        String numberOfPeople = msgReceived.Content.Substring(0, index);
                        int index2 = msgReceived.Content.IndexOf(' ', index + 1);

                        String username = msgReceived.Content.Substring(index + 1, index2 - index - 1);
                        

                        int index3 = msgReceived.Content.LastIndexOf(' ');
                        String ratingNumber = msgReceived.Content.Substring(index3 + 1);

                        String activityName = msgReceived.Content.Substring(index2 + 1, msgReceived.Content.Length - index2 - 1 - ratingNumber.Length - 1);
                        Activity activity = baseHandler.filterByName(activityName);
                        User user = userHandler.filterByUsername(username);
                        if (user == null) user = userHandler.filterByEmail(username);

                        int.TryParse(numberOfPeople, out int number);
                        if (activity.maxNumber - number < 0)
                        {
                            //add this as observer
                        
                            String[] data = user.subs.Split(',');
                            int ind = user.subs.IndexOf(',');
                            int.TryParse(data[0], out int num);
                             
                            if (data.Length - 1 < num)
                            {
                                msgToSend.Content = "observer";
                                Observer observer = new Observer
                                {
                                    IDU = user.ID,
                                    IDA = activity.IDA
                                };

                                adminHandler.addObserver(observer);
                                num--;
                                String rest = num.ToString() + ", " + user.subs.Substring(ind + 1);
                                adminHandler.updateUser(user.email, user.password, user.firstName, user.lastName, user.country, user.address, user.city, user.state, num.ToString());
                            }
                            else
                            {
                                msgToSend.Content = "max";
                            }
                            
                        }

                            else
                            {
                                activity.maxNumber -= number;
                                adminHandler.updateActivity(activity.name, activity.type, activity.hours, activity.location, activity.available.ToString(), activity.maxNumber.ToString(), activity.pricePerPerson.ToString(), ratingNumber.ToString());
                                //and add this in report
                                Report report = new Report
                                {
                                    IDA = activity.IDA,
                                    ID = user.ID
                                };
                                adminHandler.addReport(report);
                                msgToSend.Content = "reported";
                            }
                        msgToSend.activityContent = activity;
                        msgToSend.messageType = MessageType.REGISTER;

                        break;
                    }
                case MessageType.HANDLE_ACTIVITIES:
                    {
                        List<Activity> activities = baseHandler.filterByType(msgReceived.Content);
                        msgToSend.activities = activities.Count == 0 ? null : activities;
                        msgToSend.messageType = MessageType.HANDLE_ACTIVITIES;
                        break;
                    }
                case MessageType.CREATE_ACTIVITY:
                    {
                        Activity receivedActivity = msgReceived.activityContent;
                        bool condition = receivedActivity.location != "" && receivedActivity.hours != "" && receivedActivity.type != "";
                        
                        if (receivedActivity.name.CompareTo("") != 0)
                        {
                            Activity alreadyInDatabase = adminHandler.filterByName(receivedActivity.name);
                            if(alreadyInDatabase == null)
                            {
                                //nu exista, creeaza
                                if (condition)
                                {
                                    adminHandler.createActivity(receivedActivity.name, receivedActivity.type, receivedActivity.hours, receivedActivity.location, receivedActivity.available.ToString(), receivedActivity.maxNumber.ToString(), receivedActivity.pricePerPerson.ToString(), receivedActivity.rate.ToString());
                                    msgToSend.Content = "created";
                                }
                                else
                                {
                                    msgToSend.Content = "Complete all mandatory fields";
                                }
                            }
                            else
                            {
                                //just update
                                adminHandler.updateActivity(receivedActivity.name, receivedActivity.type, receivedActivity.hours, receivedActivity.location, receivedActivity.available.ToString(), receivedActivity.maxNumber.ToString(), receivedActivity.pricePerPerson.ToString(), receivedActivity.rate.ToString());
                                msgToSend.Content = "updated";
                                //here we should notify all observers
                                
                            }
                            msgToSend.activityContent = alreadyInDatabase;
                        }
                        msgToSend.messageType = MessageType.CREATE_ACTIVITY;
                        
                        break;
                    }
                case MessageType.FIND_BY_EMAIL:
                    {
                        User user = baseHandler.filterByEmail(msgReceived.Content);
                        msgToSend.Content = msgReceived.Content;
                       
                        msgToSend.userContent = user ?? null;
                        msgToSend.messageType = MessageType.FIND_BY_EMAIL;
                        break;
                    }
                case MessageType.DELETE_ACCOUNT:
                {
                        User user = baseHandler.filterByEmail(msgReceived.Content);

                        if(user != null)
                        {
                            adminHandler.deleteUser(msgReceived.Content);
                            msgToSend.Content = msgReceived.Content;
                        }
                        else
                        {
                            msgToSend.Content = "null";
                        }
                        
                        msgToSend.userContent = user ?? null ;
                        msgToSend.messageType = MessageType.DELETE_ACCOUNT;
                        break;
                }
                case MessageType.DELETE_ACTIVITY:
                {
                        Activity activity = baseHandler.filterByName(msgReceived.Content);
                        if(activity != null)
                        {
                            adminHandler.deleteActivity(msgReceived.Content);
                            msgToSend.Content = msgReceived.Content;
                        }
                        else
                        {
                            msgToSend.Content = "null";
                        }
                       
                        msgToSend.messageType = MessageType.DELETE_ACTIVITY;
                        break;
                }
                case MessageType.CREATE_ACCOUNT:
                {
                        String[] received = { msgReceived.userContent.email, msgReceived.userContent.password, msgReceived.userContent.firstName, msgReceived.userContent.lastName, msgReceived.userContent.country, msgReceived.userContent.address, msgReceived.userContent.city, msgReceived.userContent.state };
                        String[] data = msgReceived.Content.Split(',');
                        bool condition = false;
                        String mode = "";
                        condition = received[1].CompareTo("") != 0 && received[2].CompareTo("") != 0 && received[3].CompareTo("") != 0 && received[4].CompareTo("") != 0 && received[5].CompareTo("") != 0 && received[6].CompareTo("") != 0 && received[7].CompareTo("") != 0;
                        mode = data[0];
                        if (received[0].CompareTo("") != 0)
                        {
                            User user = baseHandler.filterByEmail(received[0]);
                            if (user != null) {

                                if (mode.CompareTo("") != 0)
                                {
                                    //update the existing user
                                    msgToSend.Content = "updated";
                                    int index = 2;
                                    while (true)
                                    {
                                        if (data[index].CompareTo("") != 0)
                                        {
                                            Activity activity = adminHandler.filterByName(data[2].TrimStart());
                                            if (activity != null)
                                            {
                                                Observer observer = new Observer
                                                {
                                                    IDU = user.ID,
                                                    IDA = activity.IDA
                                                };

                                                adminHandler.addObserver(observer);
                                            }
                                        }
                                        if (index == data.Length - 1) break;
                                        index++;
                                    }
                                    int i = msgReceived.Content.IndexOf(',');
                                    String subs = msgReceived.Content.Substring(i + 1);
                                    adminHandler.updateUser(received[0], received[1], received[2], received[3], received[4], received[5], received[6], received[7], subs);
                                }
                                else
                                {
                                    //account already exists - users can not update
                                    msgToSend.Content = "Account already exists";
                                }
                            }
                            else
                            {
                                //create account
                                if (condition == true)
                                {
                                    msgToSend.Content = "created";
                                    adminHandler.createUser(received[0], received[1], received[2], received[3], received[4], received[5], received[6], received[7]);
                                }
                                else
                                {
                                    msgToSend.Content = "Complete all mandatory fields";
                                }
                            }
                        }
                        
                        msgToSend.messageType = MessageType.CREATE_ACCOUNT;
                        break;
                }
                case MessageType.HANDLE_SEARCH:
                    {
                        
                        List<Activity> activities = new List<Activity>();
                        if (msgReceived.Content.Contains("stars"))
                        {
                            int index = msgReceived.Content.IndexOf(' ');
                            String number = msgReceived.Content.Substring(0, index);
                            int.TryParse(number, out int ratingNumber);
                            activities = baseHandler.filterByRate(ratingNumber);
                            msgToSend.activities = activities;
                        }
                        else
                        {
                            Activity activity = baseHandler.filterByName(msgReceived.Content);
                            msgToSend.Content = msgReceived.Content;
                            if (activity != null)
                            {
                                msgToSend.activityContent = activity;
                            }
                            else
                            {
                                activities = baseHandler.filterByHours(msgReceived.Content);
                                if (activities != null && activities.Count > 0)
                                {
                                    msgToSend.activities = activities;
                                }
                                else
                                {
                                    activities = baseHandler.filterByLocation(msgReceived.Content);
                                    if (activities != null && activities.Count > 0)
                                    {
                                        msgToSend.activities = activities;
                                    }
                                    else
                                    {
                                        activities = baseHandler.filterByType(msgReceived.Content);
                                        if (activities != null && activities.Count > 0)
                                        {
                                            msgToSend.activities = activities;
                                        }
                                        else
                                        {
                                            if (BaseHandler.username.Trim().CompareTo("") == 0)
                                            {
                                                //admin mode - can search after user too
                                                User user = baseHandler.filterByEmail(msgReceived.Content);
                                                if (user != null)
                                                {
                                                    msgToSend.userContent = user;
                                                }
                                                else
                                                {
                                                    user = baseHandler.filterByUsername(msgReceived.Content);
                                                    msgToSend.userContent = user;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        msgToSend.messageType = MessageType.HANDLE_SEARCH;
                        break;
                    }
                case MessageType.LOG_IN: {
                        
                        User user = new User();

                        String[] received = msgReceived.Content.Split(' ');
                        if (received.Length < 2)
                        {
                            user = null;
                        }
                        else
                        {
                            String username = received[0];
                            BaseHandler.username = username;
                            String password = received[1];
                            user = baseHandler.filterByUsername(username);
                            if (user == null)
                            {
                                user = baseHandler.filterByEmail(msgReceived.Content);
                                if (user != null)
                                {
                                    if (user.password.CompareTo(password) != 0)
                                    {
                                        user = null;
                                    }
                                }
                            }
                            else
                            {
                                if (user.password.CompareTo(password) != 0)
                                {
                                    user = null;
                                }
                            }
                            msgToSend.Content = msgReceived.Content;
                            msgToSend.userContent = user;
                            msgToSend.messageType = MessageType.LOG_IN;
                        }
                        break;
                }
                case MessageType.FIND_BY_USERNAME: {
                        
                        String username = msgReceived.Content;
                        User user = baseHandler.filterByUsername(username);
                        msgToSend.Content = username;
                        msgToSend.userContent = user ?? null;
                        msgToSend.messageType = MessageType.FIND_BY_USERNAME;
                        break;
                }
                case MessageType.FIND_BY_NAME:
                    {
                        String name = msgReceived.Content;
                        Activity activity = baseHandler.filterByName(name);
                        msgToSend.Content = msgReceived.Content;
                        msgToSend.activityContent = activity;
                        msgToSend.messageType = MessageType.FIND_BY_NAME;
                        break;
                    }

            }
    
            return msgToSend;
        }

        public void send(Socket socket, Message msgToSend)
        {
            MemoryStream stream = Serializer.ToStream(msgToSend);
            socket.Send(stream.GetBuffer());
        }
    }
}
