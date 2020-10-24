 using System;
using System.Collections.Generic;
using core.Models;
using server.Service;

namespace server.RequestHandler
{
    public class AdminHandler : BaseHandler
    {
        public AdminHandler()
        {

        }

        public bool createUser(String userEmail, String userPassword, String userFName, String userLName, String userCountry, String userAddress, String userCity, String userState)
        {
            if (userPassword != "" && userFName != "" && userLName != "" && userAddress != "" && userCountry != "" && userState != "" && userCity != "")
            {
                User user = new User(userEmail, userPassword, userFName, userLName, userCountry, userAddress, userCity, userState, "2");
                userService.add(user);
                return true;
            }
            return false;
        }

        public bool updateUser(String userEmail, String userPassword, String userFName, String userLName, String userCountry, String userAddress, String userCity, String userState, String subscribtions)
        {
            User user = userService.findByEmail(userEmail);


            if (user == null) return false;
            if (userPassword != "")
            {
                user.password = userPassword;
            }
            if (userFName != "")
            {
                user.firstName = userFName;
            }
            if (userLName != "")
            {
                user.lastName = userLName;
            }
            if (userCity != "")
            {
                user.city = userCity;
            }
            if (userAddress != "")
            {
                user.address = userAddress;
            }
            if (userState != "")
            {
                user.state = userState;
            }
            if (userCountry != "")
            {
                user.country = userCountry;
            }
            if(subscribtions.CompareTo("") != 0)
            {
                user.subs = subscribtions;
            }
            userService.update(user);
            return true;
        }

        public bool deleteUser(String username)
        {
            User user = userService.findByEmail(username);
            if (user == null) return false;
            userService.delete(user);
            return true;
        }

        public bool createActivity(String activityName, String activityType, String activityHours, String activityLocation, String activityAvailable, String activityMaxNumber, String price, String ratingNumber)
        {

            if (activityType != "" && activityHours != "" && activityLocation != "" && activityAvailable != "" && price != "")
            {
                bool av = activityAvailable == "true" ? true : false;
                int maxNumber = activityMaxNumber == "" ? 0 : Int32.Parse(activityMaxNumber);
                int.TryParse(price, out int pr);
             
                Activity activity = new Activity(activityName, activityType, activityHours, activityLocation, av, maxNumber, pr, 3);
                activityService.addActivity(activity);
                return true;
            }
            return false;
        }

        public bool updateActivity(String activityName, String activityType, String activityHours, String activityLocation, String activityAvailable, String activityMaxNumber, String price, String ratingNumber)
        {
            Activity activity = activityService.findByName(activityName);
            if (activity == null) return false;
            if (activityType.Trim() != "")
            {
                activity.type = activityType;
            }
            if (activityHours != "")
            {
                activity.hours = activityHours;
            }
            if (activityLocation != "")
            {
                activity.location = activityLocation;
            }
            if (activityAvailable.Trim() != "")
            {
                activity.available = activityAvailable == "true" ? true : false;
            }
            if (activityMaxNumber.Trim() != "")
            {
                activity.maxNumber = Int32.Parse(activityMaxNumber);

            }
            if (price.Trim() != "")
            {
                activity.pricePerPerson = Int32.Parse(price);
            }
            activityService.updateActivity(activity);
          
            return true;
        }

        public bool deleteActivity(String activityName)
        {
            Activity activity = activityService.findByName(activityName);
            Console.WriteLine(activity.name);
            if (activity == null)
            {
                return false;
            }
            activityService.deleteActivity(activity);
            return true;
        }

        public void addReport(Report report)
        {
            reportService.add(report);
        }
        public List<Report> getAllReports()
        {
            List<Report> list = reportService.getAllReports();
            return list;
        }

        public void addObserver(Observer observer)
        {
            observerService.add(observer);
        }
    }

}