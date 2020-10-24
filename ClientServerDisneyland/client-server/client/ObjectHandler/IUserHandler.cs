using System;
namespace client.ObjectHandler
{
    public interface IUserHandler
    {
        void handleActivities(String type);
        void updateRating(String activityName, String ratingNumber);
        void handleActivitiesName(String name);
        void register(String number, String username, String activityName, String ratingNumber);
        void viewRegistrations(String username);
        void unregister(String username, String activityName);
    }
}
