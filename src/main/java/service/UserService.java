package service;

import dao.UserJdbcDAO;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public void saveUser(User user) {
        UserJdbcDAO dao = getUserDAO();
        dao.addUser(user);
    }

    public List<User> findAllUsers() {
        UserJdbcDAO dao = getUserDAO();
        return dao.getAllUsers();
    }

    public User findUser(Long id) {
        UserJdbcDAO dao = getUserDAO();
        return dao.findUserById(id);
    }

    public void updateUser(User user) {
        UserJdbcDAO dao = getUserDAO();
        dao.updateUser(user);
    }

    public void deleteUser(User user) {
        UserJdbcDAO dao = getUserDAO();
        dao.deleteUser(user);
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=10293847&").
                    append("serverTimezone=UTC");   //setup server time

            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("Проблемы Соединения");
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }


    private static UserJdbcDAO getUserDAO() {
        return new UserJdbcDAO(getMysqlConnection());
    }
}
