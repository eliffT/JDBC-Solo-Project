package com.elif;

import com.elif.config.DatabaseConnectionConfig;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try{
            Connection conn = DatabaseConnectionConfig.getConnection();
            System.out.println("Connected!");
            conn.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}