using System.Collections.Generic;
using core.Models;
namespace server.Repository
{
    public interface IUserRepository
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
