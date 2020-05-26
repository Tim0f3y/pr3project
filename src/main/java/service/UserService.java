package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import java.util.List;

public class UserService {
    public void saveUser(User user) {
        UserHibernateDAO dao = new UserHibernateDAO();
        //UserJdbcDAO dao = new UserJdbcDAO();
        dao.addUser(user);
    }

    public List<User> findAllUsers() {
        UserHibernateDAO dao = new UserHibernateDAO();
        //UserJdbcDAO dao = new UserJdbcDAO();
        return dao.getAllUsers();
    }

    public User findUser(Long id) {
        UserHibernateDAO dao = new UserHibernateDAO();
        //UserJdbcDAO dao = new UserJdbcDAO();
        return dao.findUserById(id);
    }

    public void updateUser(User user) {
        UserHibernateDAO dao = new UserHibernateDAO();
        //UserJdbcDAO dao = new UserJdbcDAO();
        dao.updateUser(user);
    }

    public void deleteUser(User user) {
        UserHibernateDAO dao = new UserHibernateDAO();
        //UserJdbcDAO dao = new UserJdbcDAO();
        dao.deleteUser(user);
    }


}
