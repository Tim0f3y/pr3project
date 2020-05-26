package dao;

import model.User;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class UserHibernateDAO implements UserDAO {

    @Override
    public List<User> getAllUsers() {
        Session session = configureSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public User findUserById(Long id) {
        Session session = configureSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteUser(User user) {
        Session session = configureSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public void addUser(User user) {
        Session session = configureSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        Session session = configureSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    private SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
