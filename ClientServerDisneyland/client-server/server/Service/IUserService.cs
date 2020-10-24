using System;
using System.Collections.Generic;
using core.Models;

namespace server.Service
{
    public interface IUserService
    {
        List<User> getAllUsers();
        User findById(int id);
        User findByEmail(string email);
        User findByUsername(string username);
        void add(User user);
        void update(User user);
        void delete(User user);
    }
}
