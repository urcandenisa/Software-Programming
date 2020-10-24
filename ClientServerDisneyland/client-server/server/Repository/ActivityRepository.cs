using System;
using System.Collections.Generic;
using System.Linq;
using server.DataAccess;
using core.Models;

namespace server.Repository
{
    public class ActivityRepository : IActivityRepository
    {
        private readonly DBContext _context;

        public ActivityRepository()
        {
            _context = new DBContext();
        }

        public Activity findById(int id)
        {
            return _context.dataAccess.Get<Activity>(id);
        }

        public List<Activity> getAllActivities()
        {
            List<Activity> activities = new List<Activity>();
            var tableData = _context.dataAccess.Table<Activity>();
            foreach (Activity activity in tableData)
            {
                activities.Add(activity);
            }
            return activities;
        }

        public Activity findByName(string name)
        {
            var activity = from a in _context.dataAccess.Table<Activity>() where a.name.Contains(name) select a;

            return activity.FirstOrDefault();
        }

        public List<Activity> findByType(string type)
        {
            var activitiesQuery = from a in _context.dataAccess.Table<Activity>() where a.type.Equals(type) select a;
            return activitiesQuery.ToList();
        }



        public List<Activity> findByHours(string hoursInput)
        {
            //check contained hours
            List<Activity> activities = new List<Activity>();
            if (hoursInput.Length < 5) return null;
            try
            {
                var check = Int32.Parse(hoursInput.Substring(0, 2).ToString());
            }catch(Exception exc)
            {
                return null;
            }
           
            /* splitting the string of input in a list of string/hours */
            int positionOfCommaForInput = hoursInput.IndexOf(',');
            List<String> hoursForInput = new List<String>();
            while (positionOfCommaForInput != -1)
            {
                hoursForInput.Add(hoursInput.Substring(0, 5));
                hoursInput = hoursInput.Substring(positionOfCommaForInput + 2, hoursInput.Length - 7);
                positionOfCommaForInput = hoursInput.IndexOf(',');
            }

            hoursForInput.Add(hoursInput.Substring(0, 5));

            foreach (String input in hoursForInput)
            {
                bool found = false;
                foreach (Activity activity in _context.dataAccess.Table<Activity>())
                {
                    /* splitting the string of activity in a list of string/hours */
                    int positionOfCommaForActivity = activity.hours.IndexOf(','); //-1 if it doesn't exist

                    List<String> hoursForActivities = new List<String>();

                    var hours = activity.hours;
                    while (positionOfCommaForActivity != -1) //so it has at least one comma
                    {
                        hoursForActivities.Add(hours.Substring(0, 5));
                        hours = hours.Substring(positionOfCommaForActivity + 2, hours.Length - 7); //+2 because of white space
                        positionOfCommaForActivity = hours.IndexOf(',');

                    }
                    hoursForActivities.Add(hours.Substring(0, 5));

                    foreach (String activityHour in hoursForActivities)
                    {
                        if (Int32.Parse(input.Substring(0, 2).ToString()) >= Int32.Parse(activityHour.Substring(0, 2).ToString())
                     && Int32.Parse(input.Substring(3, 2).ToString()) <= Int32.Parse(activityHour.Substring(3, 2).ToString()))
                        {
                            activities.Add(activity);
                            found = true;
                            break;
                        }
                    }

                    if (found == true) break;
                }
            }

            return activities;
        }

        public List<Activity> findByLocation(string location)
        {
            var activity = from a in _context.dataAccess.Table<Activity>() where a.location.Equals(location) select a;

            return activity.ToList();
        }

        public void addActivity(Activity activity)
        {
            _context.dataAccess.Insert(activity);
        }

        public void deleteActivity(Activity activity)
        {
            _context.dataAccess.Delete(activity);
        }

        public void updateActivity(Activity activity)
        {
            _context.dataAccess.Update(activity);
        }

        public List<Activity> findByRate(int ratingNumber)
        {
            var activity = from a in _context.dataAccess.Table<Activity>() where a.rate.Equals(ratingNumber) select a;

            return activity.ToList();
        }
    }
}
