using System;
using System.Collections.Generic;
using core.Models;

namespace server.Repository
{
    public interface IObserverRepository
    {
        void add(Observer observer);
        void delete(Observer observer);
        List<Observer> getAllObservers();
        List<Observer> findObsByIdUser(int id);
    }
}
