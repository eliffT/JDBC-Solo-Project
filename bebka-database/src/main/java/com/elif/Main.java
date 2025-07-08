package com.elif;

import com.elif.config.DatabaseConnectionConfig;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";

        try{
            Connection conn = DatabaseConnectionConfig.getConnection();
            System.out.println("Connected!");
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Table created.");
            statement.close();
            conn.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}