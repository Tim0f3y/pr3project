package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

    public UserDAO getUserDAO() {
        UserDAO userDAO = null;
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(".properties")) {
            props.load(input);
            String prop = props.getProperty("daoType");
            if (prop.equals("UserJdbcDAO")) {
                userDAO = new UserJdbcDAO();
            } else {
                userDAO = new UserHibernateDAO();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDAO;
    }
}
