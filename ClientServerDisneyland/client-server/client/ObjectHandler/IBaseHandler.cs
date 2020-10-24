using System;
using core;

namespace client.ObjectHandler
{
    public interface IBaseHandler
    {
        void logIn(String username, String password);
        void findByUsername(String username);
        void handleSearch(String searchingAfter);
        void handle(Message message);
    }
}
