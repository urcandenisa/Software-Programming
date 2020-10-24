using System;
using System.Collections.Generic;
using core.Models;
namespace server.Repository
{
    public interface IActivityRepository
    {
        List<Activity> getAllActivities();
        Activity findByName(String name);
        Activity findById(int id);
        List<Activity> findByType(String type);
        List<Activity> findByHours(String hours);
        List<Activity> findByLocation(String location);
        List<Activity> findByRate(int ratingNumber);
        void addActivity(Activity activity);
        void updateActivity(Activity activity);
        void deleteActivity(Activity activity);
    }
}
