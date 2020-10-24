using System;
using server.Repository;
using System.Collections.Generic;
using core.Models;

namespace server.Service
{
    public class ActivityService : IActivityService
    {
        private IActivityRepository context;

        public ActivityService()
        {
            this.context = new ActivityRepository();
        }

        public List<Activity> getAllActivities()
        {
            List<Activity> activities = context.getAllActivities();
            if (activities == null) return null;
            return activities;
        }

        public Activity findById(int id)
        {
            return context.findById(id);
        }

        public Activity findByName(String name)
        {
            Activity activity = context.findByName(name);
            if (activity == null) return null;
            return activity;
        }

        public List<Activity> findByType(String type)
        {
            List<Activity> activities = context.findByType(type);
            if (activities == null) return null;
            return activities;
        }

        public List<Activity> findByRate(int ratingNumber)
        {
            List<Activity> activities = context.findByRate(ratingNumber);
            if (activities == null) return null;
            return activities;
        }

        public List<Activity> findByHours(String hours)
        {
            List<Activity> activities = context.findByHours(hours);
            if (activities == null) return null;
            return activities;
        }

        public List<Activity> findByLocation(String location)
        {
            List<Activity> activities = context.findByLocation(location);
            if (activities == null) return null;
            return activities;
        }

        public void addActivity(Activity activity)
        {
            context.addActivity(activity);
        }

        public void updateActivity(Activity activity)
        {
            context.updateActivity(activity);
        }

        public void deleteActivity(Activity activity)
        {
            context.deleteActivity(activity);
        }
    }
}
