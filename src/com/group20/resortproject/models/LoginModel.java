package com.group20.resortproject.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.group20.resortproject.data.Tuple;

import com.group20.resortproject.data.DBManager;

public class LoginModel extends Model {

    public Tuple<Integer, String> login(String email) {
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

}
