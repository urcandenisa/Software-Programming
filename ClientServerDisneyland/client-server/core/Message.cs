using System;
using System.Collections.Generic;
using core.Models;

namespace core
{
    [Serializable]
    public class Message
    {
        public String Content { get; set; }
        public MessageType messageType { get; set; }
        public User userContent { get; set; }
        public Activity activityContent { get; set; }
        public List<Activity> activities { get; set; }
    }

    public enum MessageType
    {
        LOG_IN,
        FIND_BY_USERNAME,
        REGISTER,
        FIND_BY_NAME, //activity
        FIND_BY_EMAIL,
        NOTIFY,
        HANDLE_SEARCH,
        UNREGISTER,
        CREATE_ACCOUNT,
        DELETE_ACCOUNT,
        HANDLE_ACTIVITIES,
        DELETE_ACTIVITY,
        CREATE_ACTIVITY,
        VIEW_REGISTRATIONS,
        HANDLE_ACTIVITIES_NAME,
        UPDATE_RATING
    }
}
