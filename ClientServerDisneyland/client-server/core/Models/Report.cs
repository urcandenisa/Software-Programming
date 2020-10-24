using System;
using System.Collections.Generic;
using SQLite;
using SQLiteNetExtensions.Attributes;
namespace core.Models
{
    [Serializable]
    public class Report
    {
        [PrimaryKey, AutoIncrement]
        public int IDR { get; set; }

        [ForeignKey(typeof(User))]
        public int ID { get; set; }

        [ForeignKey(typeof(Activity))]
        public int IDA { get; set; }

        [OneToOne]
        public User user { get; set; }
        [OneToOne]
        public Activity activity { get; set; }


        public Report()
        {
        }
    }
}
