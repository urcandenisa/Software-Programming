using System;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using client.ConnectionHandler;
using core;
using core.Models;

namespace client.ObjectHandler
{
    public class BaseHandler : IBaseHandler
    {
        public static String username;
        public static String activityName;

        private IMessageHandler messageHandler;

        public IMessageController messageController { get; set; }

        public BaseHandler()
        {
            this.messageHandler = new MessageHandler(this);
        }

        public BaseHandler(IMessageController messageController, IMessageHandler messageHandler)
        {
            this.messageController = messageController;
            this.messageHandler = messageHandler;
        }

        public BaseHandler(IMessageController messageController)
        {
            this.messageController = messageController;
            this.messageHandler =  new MessageHandler(this);
        }

        public void logIn(String username, String password)
        {
            Message message = new Message
            {
                messageType = MessageType.LOG_IN,
                Content = username + " " + password
            };

            messageHandler.sendMessage(message);
            
        }

        public void findByUsername(String username)
        {
            Message message = new Message
            {
                messageType = MessageType.FIND_BY_USERNAME,
                Content = username
            };

            messageHandler.sendMessage(message);
        }

        public void handleSearch(String searchingAfter)
        {
            Message message = new Message
            {
                messageType = MessageType.HANDLE_SEARCH,
                Content = searchingAfter
            };

            messageHandler.sendMessage(message);
        }

        public void handle(Message message)
        {
            Console.WriteLine(" I AM " + messageController.GetType().ToString() + "\n");
            switch (message.messageType)
            {
                case MessageType.UPDATE_RATING:
                    {
                        break;
                    }
                case MessageType.HANDLE_ACTIVITIES_NAME:
                    {
                        messageController.showActivity(message.activityContent);
                        break;
                    }
                case MessageType.UNREGISTER:
                    {
                        messageController.showMessage("Your reservation was successfully unregistered!");
                        break;
                    }
                case MessageType.VIEW_REGISTRATIONS:
                    {
                        messageController.showList(message.activities);
                        break;
                    }
                case MessageType.REGISTER:
                    {
                        if(message.Content.CompareTo("max") == 0)
                        {
                            messageController.showMessage("You have reached the maximum number of subscriptions!");
                        }
                        if (message.Content.CompareTo("observer") == 0)
                        {
                            messageController.showMessage("Could not make reservation. Please try again!");
                        }
                        else
                        {
                            messageController.showMessage("   Your reservation was successfully done!");
                        }
                        break;
                    }
                case MessageType.HANDLE_ACTIVITIES:
                    {
                        messageController.showList(message.activities);
                        break;
                    }
                case MessageType.NOTIFY:
                    {
                        Console.WriteLine("I am notified");
                        messageController.showAlert();
                        break;
                    }
                case MessageType.CREATE_ACTIVITY:
                    {
                        if (message.Content.CompareTo("created") == 0)
                        {
                            messageController.showMessage("Your activity was successfully created!");
                        }
                        else if (message.Content.CompareTo("updated") == 0)
                        {
                            messageController.showMessage("Your account was successfully updated!");
                        }
                        else
                        {
                            messageController.showMessage("Please complete the mandatory fields!");
                        }
                        break;
                    }
                case MessageType.FIND_BY_NAME:
                    {
                        messageController.showActivity(message.activityContent);
                        break;
                    }
                case MessageType.FIND_BY_EMAIL:
                    {
                        messageController.showUser(message.userContent);
                        break;
                    }
                case MessageType.DELETE_ACTIVITY:
                    {
                        if(message.Content.CompareTo("null") == 0)
                        {
                            messageController.showMessage("  Activity doesn't exist in database!");
                        }
                        else
                        {
                            messageController.showMessage("Your activity was successfully deleted!");
                        }
                        break;
                    }
                case MessageType.DELETE_ACCOUNT:
                    {
                        if(message.Content.CompareTo("null") == 0)
                        {
                            messageController.showMessage("  Account doesn't exist in database!");
                        }
                        else
                        {
                            messageController.showMessage("Your account was successfully deleted!");
                        }
                        break;
                    }
                case MessageType.CREATE_ACCOUNT:
                    {
                        if(message.Content.CompareTo("created") == 0)
                        {
                            messageController.showMessage("Your account was successfully created!");
                        }
                        if(message.Content.CompareTo("Complete all mandatory fields") == 0)
                        {
                            messageController.showMessage("Please complete the mandatory fields!");
                        }
                        else
                        {
                            if(message.Content.CompareTo("Account already exists") == 0)
                            {
                                messageController.showMessage(" Account already exists in database!");
                            }
                            else
                            if (message.Content.CompareTo("updated") == 0)
                            {
                                messageController.showMessage("Your account was successfully updated!");
                            }
                        }
                        break;
                    }
                case MessageType.LOG_IN:
                    {
                        //check if user is null
                        if (message.userContent == null)
                        {
                            messageController.showMessage("Incorrect username / password!");
                        }
                        else
                        {
                            BaseHandler.username = message.Content;
                            messageController.openWindow();
                        }
                        break;
                    }
                case MessageType.FIND_BY_USERNAME:
                    {
                        messageController.showMessage(message.userContent.firstName + " " + message.userContent.lastName);
                        break;
                    }
                case MessageType.HANDLE_SEARCH:
                    {
                        if(message.activityContent != null)
                        {
                            messageController.showActivity(message.activityContent);
                        }
                        else
                        {
                            if(message.activities != null)
                            {
                                messageController.showList(message.activities);
                            }
                            else
                            {
                                if(message.userContent != null)
                                {
                                    messageController.showUser(message.userContent);
                                }
                            }
                        }
                        break;
                    }
            }
         
        }
    }
}
