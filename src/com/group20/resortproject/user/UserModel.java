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

    /**
     * finds a user given their ID
     * 
     * @param id
     * @return the user if found
     */
    static User findUser(int id) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;

        // execute query
        try {
            statement = conn
                    .prepareStatement(
                            "SELECT firstName, lastName, email, dob, phone, credit FROM users WHERE userID = ?");

            statement.setInt(1, id);

            result = statement.executeQuery();

            // if the results match returns user information
            if (result.next()) {
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String email = result.getString("email");
                LocalDate dob = result.getDate("dob").toLocalDate();
                String phone = result.getString("phone");
                float credit = result.getFloat("credit");

                return new User(id, firstName, lastName, email, dob, phone, credit);
            }

            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * reads the database to find a user
     * 
     * @param email
     * @return email and password
     */
    static Tuple<Integer, String> findLogin(String email) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;

        // try execute the query
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

    /**
     * inserts a new user into the database
     * 
     * @param firstName
     * @param lastName
     * @param dob
     * @param email
     * @param phone
     * @param password
     */
    static void insertUser(String firstName, String lastName, LocalDate dob, String email, String phone,
            String password) throws SQLException {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        // execute insert to update a new user into database
            statement = conn.prepareStatement(
                    "INSERT INTO Users(firstName, lastName, dob, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, Date.valueOf(dob));
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setString(6, password);

            statement.executeUpdate();
    }

    /**
     * updates a users details when changes are made
     * 
     * @param user
     * @throws Exception
     */
    static void updateUser(User user) throws Exception {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        // executes update statement to try update user details
        try {
            statement = conn.prepareStatement(
                    "UPDATE Users SET firstName = ?, lastName = ?, dob = ?, email = ?, phone = ?, credit = ? WHERE userID = ?");

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getDob()));
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setFloat(6, user.getCredit());
            statement.setInt(7, user.getID());

            System.out.println("Executed...");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Something went wrong while updating user info.");
        }
    }

}
