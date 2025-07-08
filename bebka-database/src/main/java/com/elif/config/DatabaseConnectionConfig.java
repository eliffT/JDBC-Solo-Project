package com.elif.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionConfig {
    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(DatabaseConfig.DATABASE_URL,
                    DatabaseConfig.DATABASE_USERNAME, DatabaseConfig.DATABASE_PASSWORD);
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
