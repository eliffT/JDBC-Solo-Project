package com.elif;


import com.elif.config.DatabaseConnectionConfig;
import com.elif.dao.UserDAO;
import com.elif.dao.UserDAOImpl;
import com.elif.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            DatabaseConnectionConfig.setConnection();
            Connection connection = DatabaseConnectionConfig.getConnection();

            UserDAO userDAO = new UserDAOImpl(connection);
            // CREATE TABLE
            // userDAO.createTable();

            // SAVE

            User newUser = new User("Buse", 20);
            userDAO.save(newUser);
            System.out.println("New user added.");

            // DELETE
          //  userDAO.delete(8);

            // UPDATE
            /*
            User updatedUser = new User();
            updatedUser.setId(3);
            updatedUser.setName("Zeynep");
            updatedUser.setAge(27);
            userDAO.update(updatedUser);
            */

            // LIST
            List<User> users = userDAO.findAll();
            System.out.printf("%-5s | %-10s | %-5s\n", "ID", "NAME", "AGE");
            System.out.println("--------------------------------------------------");
            for (User user : users){
                System.out.printf("%-5d | %-10s | %-5d\n",
                        user.getId(), user.getName(), user.getAge());
                System.out.println("--------------------------------------------------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
                DatabaseConnectionConfig.closeConnection();
        }
    }
}
