using System;
using System.Collections.Generic;
using core.Models;
using server.Repository;

namespace server.Service
{
    public class ObserverService
    {

        private IObserverRepository context;
        public ObserverService()
        {
            this.context = new ObserverRepository();
        }

        public void add(Observer observer)
        {
            context.add(observer);
        }

        public void delete(Observer observer)
        {
            context.delete(observer);
        }

        public List<Observer> getAllObservers()
        {
            List<Observer> observers = context.getAllObservers();
            if (observers == null) return null;
            return observers;
        }

        public List<Observer> findObsByIdUser(int id)
        {
            List<Observer> observers = context.findObsByIdUser(id);
            if (observers == null) return null;
            return observers;
        }

    }
}
