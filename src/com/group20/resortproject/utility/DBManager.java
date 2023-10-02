package com.group20.resortproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:derby:MountainResort;create=true;";
    private static final String USERNAME = "group20";
    private static final String PASSWORD = "group20";

    private static Connection conn;

    public static Connection getConnection() {
        return conn;
    }

    // Establish connection
    public static void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                conn.setSchema("MOUNTAINRESORT");
                System.out.println(URL + " Connection Successful...");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
