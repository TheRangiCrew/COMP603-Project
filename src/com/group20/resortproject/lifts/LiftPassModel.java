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

import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.DBManager;

public class LiftPassModel {

    public static boolean addLiftPass(LiftPass pass) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        try {
            statement = conn.prepareStatement(
                    "INSERT INTO LiftPasses(validFrom, validTo, userID) VALUES (?, ?, ?)");

            statement.setTimestamp(1, new Timestamp(
                    ZonedDateTime.of(pass.getValidFrom(), ZoneId.systemDefault()).toInstant().toEpochMilli()));
            statement.setTimestamp(2, new Timestamp(
                    ZonedDateTime.of(pass.getValidTo(), ZoneId.systemDefault()).toInstant().toEpochMilli()));
            statement.setInt(3, UserController.getLoggedIn().getID());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<LiftPass> getLiftPassesForUser(int userID) {
        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        ResultSet result;
        ArrayList<LiftPass> list = new ArrayList<>();

        try {
            statement = conn
                    .prepareStatement("SELECT * FROM LiftPasses WHERE userID = ?");

            statement.setInt(1, userID);

            result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("passID");
                LocalDateTime validFrom = result.getTimestamp("validFrom").toLocalDateTime();
                LocalDateTime validTo = result.getTimestamp("validTo").toLocalDateTime();

                list.add(new LiftPass(id, validFrom, validTo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
