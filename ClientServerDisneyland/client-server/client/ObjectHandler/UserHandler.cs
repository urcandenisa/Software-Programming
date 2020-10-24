using System;
using core;

namespace client.ObjectHandler
{
    public class UserHandler : BaseHandler, IUserHandler
    {
        private IMessageHandler messageHandler;
        public UserHandler(IMessageController messageController, IMessageHandler messageHandler)
        {
            this.messageController = messageController;
            this.messageHandler = messageHandler;
        }

        public UserHandler(IMessageController messageController)
        {
            this.messageController = messageController;
            this.messageHandler = new MessageHandler(this);
        }

        public void handleActivities(String type)
        {
            Message message = new Message
            {
                messageType = MessageType.HANDLE_ACTIVITIES,
                Content = type
            };

            messageHandler.sendMessage(message);
        }

        public void updateRating(String activityName, String ratingNumber)
        {
            Message message = new Message
            {
                messageType = MessageType.UPDATE_RATING,
                Content = ratingNumber + " " + activityName
            };

            messageHandler.sendMessage(message);
        }

        public void handleActivitiesName(String name)
        {
            Message message = new Message
            {
                messageType = MessageType.HANDLE_ACTIVITIES_NAME,
                Content = name
            };

            messageHandler.sendMessage(message);
        }

        public void register(String number, String username, String activityName, String ratingNumber)
        {
            Message message = new Message
            {
                messageType = MessageType.REGISTER,
                Content = number + " " + username + " " + activityName + " " + ratingNumber
            };

            messageHandler.sendMessage(message);
        }

        

        public void viewRegistrations(String username)
        {
            Message message = new Message
            {
                messageType = MessageType.VIEW_REGISTRATIONS,
                Content = username
            };

            messageHandler.sendMessage(message);
        }

        public void unregister(String username, String activityName)
        {
            Message message = new Message
            {
                messageType = MessageType.UNREGISTER,
                Content = username + " " + activityName
            };

            messageHandler.sendMessage(message);
        }
    }
}
