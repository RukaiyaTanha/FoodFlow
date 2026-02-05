package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/foodflow",
                    "root",
                    "tanha2003"   // password
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

