package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO{


    private Connection connection;

    public UserJdbcDAO() {
        this.connection = DBHelper.getInstance().getConnection();
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User client = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")

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
        User user = null;
        String sql = "SELECT * FROM user WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(User user) {
        String sql = "DELETE FROM user WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        String sql = "INSERT INTO user(name,lastName,login,password) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "update user set name = ? , lastname = ?, login = ?, password = ?, role = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.setLong(6, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findUserByLogin(String login) {
        User user = null;
        String sql = "SELECT * FROM user WHERE login=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}