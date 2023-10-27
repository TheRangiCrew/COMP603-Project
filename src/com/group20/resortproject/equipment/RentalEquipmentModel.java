package com.group20.resortproject.equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.group20.resortproject.Model;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.DBManager;

public class RentalEquipmentModel extends Model {

    public static HashMap<EquipmentType, ArrayList<RentalItem>> getItems() {
        Connection conn = DBManager.getConnection();
        Statement statement;
        HashMap<EquipmentType, ArrayList<RentalItem>> equipment = new HashMap<>();

        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT A.*, B.RentalEquipmentTypeName, B.RentalEquipmentPrice FROM RentalEquipment A, RentalEquipmentTypes B WHERE A.equipmentType = B.rentalEquipmentTypeID ORDER BY A.equipmentType, A.equipmentSize");

            while (result.next()) {
                int id = result.getInt("equipmentID");
                String name = result.getString("equipmentName");
                String equipmentSize = result.getString("equipmentSize");
                String sizeUnit = result.getString("equipmentSizeUnit");
                int availbility = result.getInt("equipmentAvailability");
                EquipmentType type = EquipmentType.valueOf(result.getString("RentalEquipmentTypeName"));
                int price = result.getInt("RentalEquipmentPrice");

                RentalItem rentalItem = new RentalItem(id, name, equipmentSize, sizeUnit, availbility, type, price);

                if (equipment.keySet().contains(rentalItem.getEquipmentType())) {
                    equipment.get(rentalItem.getEquipmentType()).add(rentalItem);
                } else {
                    ArrayList<RentalItem> list = new ArrayList<>();
                    list.add(rentalItem);
                    equipment.put(rentalItem.getEquipmentType(), list);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipment;
    }

    public static void addRental(RentalItem item) throws Exception {

        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        try {
            statement = conn.prepareStatement(
                    "INSERT INTO Rentals (rentedFrom, rentedTo, equipmentID, userID) VALUES (?, ?, ?, ?)");

            statement.setTimestamp(1, new Timestamp(
                    ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli()));
            statement.setTimestamp(2, new Timestamp(
                    ZonedDateTime.of(LocalDateTime.now().plusDays(1), ZoneId.systemDefault()).toInstant()
                            .toEpochMilli()));
            statement.setInt(3, item.getId());
            statement.setInt(4, UserController.getLoggedIn().getID());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getRentals() {

        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        try {
            statement = conn.prepareStatement(
                    "SELECT A.rentalID, B.equipmentName FROM Rentals A, RentalEquipment B, Users C WHERE A.equipmentID = B.equipmentID AND C.userID = ?");

            statement.setInt(1, UserController.getLoggedIn().getID());
            ResultSet result = statement.executeQuery();

            ArrayList<String> rentedEquipment = new ArrayList<>();
            while (result.next()) {
                rentedEquipment.add(result.getString("equipmentName"));
            }
            return rentedEquipment;
        } catch (SQLException e) {

            return new ArrayList<String>();
        }
    }
}