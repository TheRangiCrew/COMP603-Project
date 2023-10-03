package com.group20.resortproject.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.group20.resortproject.utility.DBManager;
import com.group20.resortproject.utility.Tuple;

public class UserModel {
    
    static User findUser(int id) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;

        try {
            statement = conn.prepareStatement("SELECT firstName, lastName, email, dob, phone FROM users WHERE userID = ?");
            
            statement.setInt(1, id);

            result = statement.executeQuery();

            if (result.next()) {
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String email = result.getString("email");
                LocalDate dob = result.getDate("dob").toLocalDate();
                String phone = result.getString("phone");

                return new User(id, firstName, lastName, email, dob, phone);
            }

            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    static Tuple<Integer, String> findLogin(String email) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;

        try {
            statement = conn.prepareStatement("SELECT userID, password FROM users WHERE email = ?");
            
            statement.setString(1, email);

            result = statement.executeQuery();
        } catch (SQLException e) {
            return null;
        }

        int id;
        String dbPassword;

        try {
			if (result.next()) {
                id = result.getInt("userID");
                dbPassword = result.getString("password");
			} else {
                return null;
            }
		} catch (SQLException e) {
			return null;
		}

        return new Tuple<Integer, String>(id, dbPassword);
    }

    static void insertUser(String firstName, String lastName, LocalDate dob, String email, String phone, String password) {
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
