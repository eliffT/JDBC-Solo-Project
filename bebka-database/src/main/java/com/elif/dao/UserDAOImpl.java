package com.elif.dao;
import com.elif.user.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private final Connection connection;

    public UserDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS userss(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "age INT )";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String insertSql = "INSERT INTO userss(name, age) VALUES(?,?)";

        try (PreparedStatement prSt = connection.prepareStatement(insertSql)) {
            prSt.setString(1, user.getName());
            prSt.setInt(2, user.getAge());
            int rows = prSt.executeUpdate();
            System.out.println(rows + " user saved.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String deleteSql = "DELETE FROM userss WHERE id = ?";
        try (PreparedStatement prSt = connection.prepareStatement(deleteSql)) {
            prSt.setInt(1, id);
            int rows = prSt.executeUpdate();
            System.out.println(rows + " user deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String updateSql = "UPDATE userss SET name = ?, age = ? WHERE id = ?";
        try(PreparedStatement prSt = connection.prepareStatement(updateSql)){
            prSt.setString(1, user.getName() );
            prSt.setInt(2, user.getAge());
            prSt.setInt(3, user.getId());
            int rows = prSt.executeUpdate();
            System.out.println(rows + " user updated.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM userss";

        try (PreparedStatement prst = connection.prepareStatement(sql);
             ResultSet rs = prst.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
