package com.group20.resortproject.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:derby:MountainResort;create=true;";
    private static final String USERNAME = "group20";
    private static final String PASSWORD = "group20";

    private Connection conn;

    public DBManager() {
        establishConnection();
    }

    public Connection getConnection() {
        return this.conn;
    }

    // Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println(URL + " Connection Successful...");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        DBManager db = new DBManager();

    }

}
