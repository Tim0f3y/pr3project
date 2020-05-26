package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO, AutoCloseable {


    public UserJdbcDAO() {
    }

    @Override
    public void close() throws Exception {

    }

    public List<User> getAllUsers() {
        Connection connection = getMysqlConnection();
        List<User> userList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User client = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname")
                );
                userList.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка пользователей");
            e.printStackTrace();
        }
        return userList;
    }

    public User findUserById(Long id) {
        Connection connection = getMysqlConnection();
        User user = null;
        String sql = "SELECT * FROM user WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(User user) {
        Connection connection = getMysqlConnection();
        String sql = "DELETE FROM user WHERE id=? AND name=? AND lastname=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser (User user){
        Connection connection = getMysqlConnection();
        String sql = "INSERT INTO user(name,lastName) VALUES(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser (User user){
        Connection connection = getMysqlConnection();
        String sql = "update user set name = ? , lastname = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection getMysqlConnection() {
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
}