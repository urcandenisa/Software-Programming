using System;
using System.Collections.Generic;
using SQLite;
using SQLiteNetExtensions.Attributes;

namespace core.Models
{
    [Serializable]
    public class User
    {
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public String email { get; set; }
        public String password { get; set; }
        public String firstName { get; set; }
        public String lastName { get; set; }
        public String country { get; set; }
        public String address { get; set; }
        public String city { get; set; }
        public String state { get; set; }
        public String subs { get; set; }

        [ManyToMany(typeof(Relation))]
        public List<Activity> activitiesTable { get; set; }

        public User()
        {

        }

        public User(String email, String password, String firstName, String lastName, String country, String address, String city, String state, String subs)
        {
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.country = country;
            this.address = address;
            this.city = city;
            this.state = state;
            this.subs = subs;
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as User);
        }

        public bool Equals(User other)
        {
            return other != null &&
                   this.ID == other.ID &&
                   this.firstName.CompareTo(other.firstName) == 0 &&
                   this.lastName.CompareTo(other.lastName) == 0 &&
                   this.country.CompareTo(other.country) == 0 &&
                   this.address.CompareTo(other.address) == 0 &&
                   this.city.CompareTo(other.city) == 0 &&
                   this.state.CompareTo(other.state) == 0
                   ;

        }


        public override string ToString()
        {
            return this.firstName + " " + this.lastName + "\n";
        }

    }
}
