package service;

import dao.UserDaoFactory;
import model.User;

import java.util.List;

public class Service {
    private static Service instance;

    UserDaoFactory daoFactory = new UserDaoFactory();

    public static synchronized Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }


    public void saveUser(User user) {
        daoFactory.getUserDAO().addUser(user);
    }


    public List<User> findAllUsers() {
        return daoFactory.getUserDAO().getAllUsers();
    }


    public User findUser(Long id) {
        return daoFactory.getUserDAO().findUserById(id);
    }


    public void updateUser(User user) {
        daoFactory.getUserDAO().updateUser(user);
    }


    public void deleteUser(User user) {
        daoFactory.getUserDAO().deleteUser(user);
    }

    public User findUserByLogin (String login){
        return  daoFactory.getUserDAO().findUserByLogin(login);
    }

}
