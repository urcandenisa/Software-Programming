using System;
using SQLite;
using SQLiteNetExtensions.Attributes;

namespace core.Models
{
    [Serializable]
    public class Observer
    {
        [PrimaryKey, AutoIncrement]
        public int IDO { get; set; }

        public String connected { get; set; }

        [ForeignKey(typeof(User))]
        public int IDU { get; set; }

        [ForeignKey(typeof(Activity))]
        public int IDA { get; set; }

        [OneToOne]
        public User user { get; set; }
        [OneToOne]
        public Activity activity { get; set; }

        public Observer()
        {

        }
    }
}
