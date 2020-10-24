using System;
using core.Models;

namespace client.ObjectHandler
{
    public interface IAdminHandler
    {
        void createAccount(String email, String password, String firstName, String lastName, String country, String address, String city, String state, String username);
        void deleteAccount(String email);
        void deleteActivity(String name);
        void createActivity(Activity activity);
        void searchUser(String email);
        void searchActivity(string name);
    }
}
