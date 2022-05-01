package com.example.tutorial02_se2_final.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String DB_URL = "jdbc:mysql://localhost/ss1finalproject";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "2882001";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to DB Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
