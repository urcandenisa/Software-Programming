using System;
using System.Collections.Generic;
using SQLite;
using SQLiteNetExtensions.Attributes;

namespace core.Models
{
    [Serializable]
    public class Activity
    {
        [PrimaryKey, AutoIncrement]
        public int IDA { get; set; }
        public String name { get; set; }
        public String type { get; set; }
        public String hours { get; set; }
        public String location { get; set; }
        public bool available { get; set; }
        public int maxNumber { get; set; }
        public int pricePerPerson { get; set; }
        public int rate { get; set; }

        [ManyToMany(typeof(Relation))]
        public List<User> activities { get; set; }

        public Activity()
        {
            
        }

        /* properties means type: Recreation, health, hours, location, availability */
        public Activity(String name, String type, String hours, String location, bool available, int maxNumber, int pricePerPerson, int rate)
        {
            this.name = name;
            this.type = type;
            this.hours = hours;
            this.location = location;
            this.available = available;
            this.maxNumber = maxNumber;
            this.pricePerPerson = pricePerPerson;
            this.rate = rate;
            
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as Activity);
        }

        public bool Equals(Activity other)
        {
            return other != null &&
                   this.IDA == other.IDA &&
                   this.name.CompareTo(other.name) == 0 &&
                   this.type.CompareTo(other.type) == 0 &&
                   this.hours.CompareTo(other.hours) == 0 &&
                   this.location.CompareTo(other.location) == 0 &&
                   this.available == other.available &&
                   this.maxNumber == other.maxNumber &&
                   this.pricePerPerson == other.pricePerPerson &&
                   this.rate == other.rate;

        }


        public override string ToString()
        {
            return name + " " + type + " " + hours + " " + location + " " + available + " " + maxNumber + " " + pricePerPerson + "\n";
        }


    }
}
