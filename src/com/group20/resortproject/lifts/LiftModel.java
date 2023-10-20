package com.group20.resortproject.lifts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

import com.group20.resortproject.utility.DBManager;

public class LiftModel {

    public static ArrayList<Lift> getLifts() {

        Connection conn = DBManager.getConnection();
        Statement statement;
        ArrayList<Lift> list = new ArrayList<>();

        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Lifts");

            while (result.next()) {
                int id = result.getInt("liftID");
                String name = result.getString("liftName");
                LocalTime openingTime = result.getTime("openingTime").toLocalTime();
                LocalTime closingTime = result.getTime("closingTime").toLocalTime();
                String liftStatus = result.getString("liftStatus");
                String liftType = result.getString("liftType");
                int length = result.getInt("length");
                int capacity = result.getInt("capacity");

                list.add(new Lift(id, name, openingTime, closingTime, liftStatus, liftType, length, capacity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
