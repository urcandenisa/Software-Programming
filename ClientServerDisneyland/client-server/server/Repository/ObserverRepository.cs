using System.Collections.Generic;
using core.Models;
using server.DataAccess;

namespace server.Repository
{
    public class ObserverRepository : IObserverRepository
    {
        private readonly DBContext _context;
        public ObserverRepository()
        {
            _context = new DBContext();
        }

        public void add(Observer observer)
        {
            _context.dataAccess.Insert(observer);
        }

        public void delete(Observer observer)
        {
            _context.dataAccess.Delete(observer);
        }

        public List<Observer> findObsByIdUser(int id)
        {
            var list = _context.dataAccess.Table<Observer>();
            List<Observer> observers = new List<Observer>();
            foreach (Observer observer in list)
            {
                if(observer.IDU == id)
                observers.Add(observer);
            }
            return observers;
        }

        public List<Observer> getAllObservers()
        {
            var list = _context.dataAccess.Table<Observer>();
            List<Observer> observers = new List<Observer>();
            foreach (Observer observer in list)
            {
                observers.Add(observer);
            }
            return observers;
        }


    }
}
