using System;
using core.Models;
using server.Service;

namespace server.RequestHandler
{
    public class UserHandler : BaseHandler
    {
        public UserHandler()
        {
            
        }
        public void registerForActivities(int numberOfPeople, String activityName)
        {
            Activity activity = activityService.findByName(activityName);
            User user = userService.findByUsername(username);
            if (activity.maxNumber - numberOfPeople < 0)
            {
                // add observer for this activitity
                observerService.add(new Observer() { IDA = activity.IDA,
                IDU = user.ID}
                    );
                return;
            }
            activity.maxNumber -= numberOfPeople;
            activityService.updateActivity(activity);
            Report report = new Report
            {
                IDA = activity.IDA,
                ID = userService.findByUsername(UserHandler.username).ID
            };  

            reportService.add(report);
        
        }
    }
}
