using System;
using System.Collections.Generic;
using core.Models;
using server.Service;

namespace server.RequestHandler
{
    public class BaseHandler
    {
        protected UserService userService;
        protected ActivityService activityService;
        protected ReportService reportService;
        protected ObserverService observerService;
        public static String username = "";

        public BaseHandler(UserService userService = null, ActivityService activityService = null, ReportService reportService = null, ObserverService observerService = null)
        {
            this.activityService = activityService ?? new ActivityService();
            this.userService = userService ?? new UserService();
            this.reportService = reportService ?? new ReportService();
            this.observerService = observerService ?? new ObserverService();
        }

        public List<Activity> filterByRate(int ratingNumber)
        {
            List<Activity> activities = activityService.findByRate(ratingNumber);
            return activities;
        }
        public Activity filterByName(String activityName)
        {
            Activity activity = activityService.findByName(activityName);
            return activity;
        }

        public List<Activity> filterByType(String activityType)
        {
            List<Activity> activity = activityService.findByType(activityType);
            return activity;
        }

        public List<Activity> filterByHours(String hours)
        {
            List<Activity> activities = activityService.findByHours(hours);
            return activities;
        }

        public List<Activity> getActivities()
        {
            return activityService.getAllActivities();
        }

        public Activity findById(int id)
        {
            return activityService.findById(id);
        }
        public List<Activity> filterByLocation(String location)
        {
            return activityService.findByLocation(location);
        }

        public User filterByEmail(String email)
        {
            return userService.findByEmail(email);
        }

        public User filterByUsername(String username)
        {
            return userService.findByUsername(username);
        }

        public List<Observer> getAllObservers()
        {
            return observerService.getAllObservers();
        }

        public List<Report> findByUserID(int id)
        {
            return reportService.findByUserID(id);
        }

        public List<Observer> findObsByUserID(int id)
        {
            return observerService.findObsByIdUser(id);
        }

        public void delete(Observer observer)
        {
            observerService.delete(observer);
        }

        public void delete(Report report)
        {
            reportService.delete(report);
        }
    }
}
