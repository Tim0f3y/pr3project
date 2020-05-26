package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User findUserById(Long id);
    public void deleteUser(User user);
    public void addUser (User user);
    public void updateUser (User user);

}
