using System;
using System.Collections.Generic;
using core.Models;

namespace server.Service
{
    public interface IActivityService
    {
        List<Activity> getAllActivities();
        Activity findById(int id);
        Activity findByName(String name);
        List<Activity> findByType(String type);
        List<Activity> findByHours(String hours);
        List<Activity> findByLocation(String location);
        List<Activity> findByRate(int ratingNumber);
        void addActivity(Activity activity);
        void updateActivity(Activity activity);
        void deleteActivity(Activity activity);
    }
}
