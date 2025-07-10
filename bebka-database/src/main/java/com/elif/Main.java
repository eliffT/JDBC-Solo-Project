package com.elif;

import com.elif.config.DatabaseConnectionConfig;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
       /*
       // Add data with PreparedStatement
       String insertSql = "INSERT INTO users(name, email) VALUES(?,?)";

        try{
            Connection conn = DatabaseConnectionConfig.getConnection();
            PreparedStatement prSt = conn.prepareStatement(insertSql);
            prSt.setString(1, "Elif");
            prSt.setString(2, "elif@gmail.com");
            prSt.executeUpdate();
            System.out.println("Record added.");
            prSt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        */

        /*
        // List data with ResultSet

        String sql = "SELECT * FROM users";

        try{
            Connection conn = DatabaseConnectionConfig.getConnection();
            PreparedStatement prSt = conn.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();

            while(resultSet.next()){
                System.out.println("-----------------------------------------------------");
                System.out.println("ID: "+ resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
            prSt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

         */

        String updateSql = "UPDATE users SET email = ? WHERE id = ?";
        String deleteSql = "DELETE FROM users WHERE id = ?";

        try{
            Connection conn = DatabaseConnectionConfig.getConnection();

           // UPDATE
            PreparedStatement prSt = conn.prepareStatement(updateSql);
            prSt.setString(1, "elftsdmr@gmail.com");
            prSt.setInt(2, 3);
            prSt.executeUpdate();

            // DELETE
            PreparedStatement pr = conn.prepareStatement(deleteSql);
            pr.setInt(1, 5);
            pr.executeUpdate();

            prSt.close();
            pr.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}