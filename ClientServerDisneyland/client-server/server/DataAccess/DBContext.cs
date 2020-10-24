using System.Collections.Generic;
using System.IO;
using core.Models;
using SQLite;

namespace server.DataAccess
{
    public class DBContext
    {
        public SQLiteConnection dataAccess { get; set; }

        private SQLiteConnection getDatabaseConnection()
        {
            //first we give the path to database
            var documents = "/Users/denisaurcan/Documents/PS/2020-30236-project-urcandenisa/FinalProject";
            //then establish a name for database
            string database = Path.Combine(documents, "disneyland.db3");
            //check if the database is already created
            bool exists = File.Exists(database);
            
            //establish connection to database
            var conn = new SQLiteConnection(database);
            //if the database is not created, create and populate with initial values
            if (!exists)
            {
                conn.CreateTable<User>();
                conn.CreateTable<Activity>();


                Activity activity = new Activity
                {
                    name = "Gadget's Go Coaster",
                    type = "Entertainment",
                    hours = "10-12, 14-16, 18-20",
                    location = "Disneyland Park, Mickey's town",
                    available = true,
                    maxNumber = 29,
                    pricePerPerson = 4,
                    rate = 4
                  
                };

                Activity activity2 = new Activity
                {
                    name = "Haunted Mansion",
                    type = "Entertainment",
                    hours = "10-12, 14-16",
                    location = "Disneyland Park, New Orleans Square",
                    available = true,
                    maxNumber = 2,
                    pricePerPerson = 10,
                    rate = 4
                };

                Activity activity3 = new Activity
                {
                    name = "King Arthur Carrousel",
                    type = "Entertainment",
                    hours = "10-16",
                    location = "Disneyland Park, Fantasyland",
                    available = true,
                    maxNumber = 20,
                    pricePerPerson = 100,
                    rate = 3
                };

                conn.Insert(activity);
                conn.Insert(activity2);
                conn.Insert(activity3);

                User user = new User
                {
                    email = "denisaurcan@icloud.com",
                    password = "1234",
                    firstName = "Denisa",
                    lastName = "Urcan",
                    country = "Romania",
                    address = "str.Lunii 22B, nr. 15",
                    city = "Cluj-Napoca",
                    state = "Cluj"
                };

                User user2 = new User
                {
                    email = "anapopescu@gmail.com",
                    password = "1234",
                    firstName = "Ana",
                    lastName = "Popescu",
                    country = "Romania",
                    address = "str.Lunii 22B, nr. 15",
                    city = "Cluj-Napoca",
                    state = "Cluj"
                };
                User user3 = new User
                {
                    email = "ioanpop@gmail.com",
                    password = "1234",
                    firstName = "Ioan",
                    lastName = "Pop",
                    country = "Romania",
                    address = "str.Lunii 22B, nr. 15",
                    city = "Cluj-Napoca",
                    state = "Cluj"
                };
                conn.Insert(user);
                conn.Insert(user2);
                conn.Insert(user3);

                conn.CreateTable<Observer>();

                conn.CreateTable<Report>();
                

            }
            return conn;
        }

        public DBContext()
        {
           dataAccess = getDatabaseConnection();
        }
    }
}
