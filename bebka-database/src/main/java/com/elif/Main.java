package com.elif;

import com.elif.config.DatabaseConnectionConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
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
    }
}