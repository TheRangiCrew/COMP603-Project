package com.group20.resortproject.gui.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import com.group20.resortproject.Model;
import com.group20.resortproject.utility.DBManager;

public class RegisterModel extends Model {

    public void addUser(String firstName, String lastName, LocalDate dob, String email, String phone, String password) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        try {
            statement = conn.prepareStatement("INSERT INTO Users(firstName, lastName, dob, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, Date.valueOf(dob));
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setString(6, password);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}