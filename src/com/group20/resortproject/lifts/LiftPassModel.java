package com.group20.resortproject.lifts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.DBManager;

public class LiftPassModel {

    /**
     * Add new lift pass and assign it to the currently logged in user
     * 
     * @param pass the lift pass to add
     * @throws SQLException
     */
    public static void addLiftPass(LiftPass pass) throws SQLException {
        Connection conn = DBManager.getConnection();

        // The statement to execute
        PreparedStatement statement;
        statement = conn.prepareStatement(
                "INSERT INTO LiftPasses(validFrom, validTo, userID) VALUES (?, ?, ?)");

        // Insert the data into the quey
        statement.setTimestamp(1, new Timestamp(
                ZonedDateTime.of(pass.getValidFrom(), ZoneId.systemDefault()).toInstant().toEpochMilli()));
        statement.setTimestamp(2, new Timestamp(
                ZonedDateTime.of(pass.getValidTo(), ZoneId.systemDefault()).toInstant().toEpochMilli()));
        statement.setInt(3, UserController.getLoggedIn().getID());

        // Execute the query
        statement.executeUpdate();
    }

    /**
     * 
     * @param userID the ID of the user to get data about
     * @return the lift passes belonging to the specified user
     */
    public static ArrayList<LiftPass> getLiftPassesForUser(int userID) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;
        ArrayList<LiftPass> list = new ArrayList<>();

        try {
            // Prepare the SQL statement
            statement = conn
                    .prepareStatement("SELECT * FROM LiftPasses WHERE userID = ?");

            statement.setInt(1, userID);

            result = statement.executeQuery();

            // Loop through the rows and convert to data types
            while (result.next()) {
                int id = result.getInt("passID");
                LocalDateTime validFrom = result.getTimestamp("validFrom").toLocalDateTime();
                LocalDateTime validTo = result.getTimestamp("validTo").toLocalDateTime();

                list.add(new LiftPass(id, validFrom, validTo));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "SQL Exception occurred while getting user lift passes\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return list;
    }

}
