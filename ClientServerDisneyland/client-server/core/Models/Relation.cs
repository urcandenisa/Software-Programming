using System;
using SQLiteNetExtensions.Attributes;

namespace core.Models
{
    public class Relation
    {
        [ForeignKey(typeof(Activity))]
        public int IDA { get; set; }

        [ForeignKey(typeof(User))]
        public int ID { get; set; }
    }
}
