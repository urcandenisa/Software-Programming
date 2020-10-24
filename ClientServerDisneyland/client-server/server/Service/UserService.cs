using System.Collections.Generic;
using core.Models;
using server.Repository;
namespace server.Service
{
    public class UserService : IUserService
    {
        private IUserRepository context;
        /*bussiness logic that uses repository, some extra check for exceptions*/
        public UserService()
        {
            this.context = new UserRepository();
        }

        public List<User> getAllUsers()
        {
            List<User> users = context.getAllUsers();
            if (users == null) return null;
            return users;
        }

        public User findById(int id)
        {
            User user = context.findById(id);
            if (user == null) return null;
            return user;
        }

        public User findByEmail(string email)
        {
            User user = context.findByEmail(email);
            if (user == null) return null;
            return user;
        }

        public User findByUsername(string username)
        {
            User user = context.findByUsername(username);
            if (user == null) return null;
            return user;
        }

        public void add(User user)
        {
            context.add(user);
        }

        public void update(User user)
        {
            context.update(user);
        }

        public void delete(User user)
        {
            context.delete(user);
        }
    }
}
