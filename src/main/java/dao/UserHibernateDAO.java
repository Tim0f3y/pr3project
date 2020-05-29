package dao;

import model.User;
import java.util.List;
import org.hibernate.Session;
import util.DBHelper;

public class UserHibernateDAO implements UserDAO {

    @Override
    public List<User> getAllUsers() {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public User findUserById(Long id) {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteUser(User user) {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public void addUser(User user) {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public User findUserByLogin(String login) {
        Session session = DBHelper.getInstance().getConfiguration()
                .getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, login);
        session.getTransaction().commit();
        return user;
    }
}
