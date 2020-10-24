using System;
using System.Collections.Generic;
using core.Models;
using server.DataAccess;
namespace server.Repository
{
    public class UserRepository : IUserRepository
    {
        private readonly DBContext _context;
        public UserRepository()
        {
            _context = new DBContext();
        }

        public List<User> getAllUsers()
        {
            List<User> users = new List<User>();
            var tableData = _context.dataAccess.Table<User>();
            foreach(User user in tableData)
            {
                users.Add(user);
            }
            return users;
        }

        public User findById(int id)
        {
            return _context.dataAccess.Get<User>(id);
        }

        public User findByEmail(String email)
        {
            var user = from s in _context.dataAccess.Table<User>() where s.email.Equals(email) select s;
     
            return user.FirstOrDefault();
        }

        public User findByUsername(String username)
        {
            var tableData = _context.dataAccess.Table<User>();
            List<User> users = new List<User>();
            foreach (User user in tableData)
            {
                users.Add(user);
                if (user.email.Substring(0, user.email.IndexOf('@')).Equals(username)){
                    return user;
                }
            }
            return null;
        }

        public void add(User user)
        {
            _context.dataAccess.Insert(user);
        }

        public void update(User user)
        {
            _context.dataAccess.Update(user);
        }

        public void delete(User user)
        {
            _context.dataAccess.Delete(user);
        }
    }
}
