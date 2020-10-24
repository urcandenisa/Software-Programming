using System;
using core;
using core.Models;

namespace client.ObjectHandler
{
    public class AdminHandler : BaseHandler
    {
        private IMessageHandler messageHandler;

        public AdminHandler(IMessageController messageController, IMessageHandler messageHandler)
        {
            this.messageController = messageController;

            this.messageHandler = messageHandler;
        }


        public AdminHandler(IMessageController messageController) 
        {
            this.messageController = messageController;

            this.messageHandler = new MessageHandler(this);
        }

        public void createAccount(String email, String password, String firstName, String lastName, String country, String address, String city, String state, String username, String subscriptions)
        {

            Message message = new Message
            {
                messageType = MessageType.CREATE_ACCOUNT,
                userContent = new User
                {
                    email = email,
                    password = password,
                    firstName = firstName,
                    lastName = lastName,
                    country = country,
                    address = address,
                    city = city,
                    state = state
                },
                Content = username + "," + subscriptions
            };

            messageHandler.sendMessage(message);
        }

        public void deleteAccount(String email)
        {
            Message message = new Message
            {
                messageType = MessageType.DELETE_ACCOUNT,
                Content = email 

            };

            messageHandler.sendMessage(message);
        }

        public void deleteActivity(String name)
        {
            Message message = new Message
            {
                messageType = MessageType.DELETE_ACTIVITY,
                Content = name

            };

            messageHandler.sendMessage(message);
        }
        public void createActivity(Activity activity)
        {
            
            Message message = new Message
            {
                messageType = MessageType.CREATE_ACTIVITY,
                activityContent = activity
            };

            messageHandler.sendMessage(message);
        }

        public void searchUser(String email)
        {
            Message message = new Message
            {
                messageType = MessageType.FIND_BY_EMAIL,
                Content = email
            };

            messageHandler.sendMessage(message);
        }

        public void searchActivity(string name)
        {
            Message message = new Message
            {
                messageType = MessageType.FIND_BY_NAME,
                Content = name
            };

            messageHandler.sendMessage(message);
        }
    }
}
