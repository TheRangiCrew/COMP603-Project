package com.group20.resortproject.equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.group20.resortproject.Model;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.DBManager;

public class RentalEquipmentModel extends Model {

    /**
     *
     * @return a Hashmap of RentalItems available in the rentalEquipment organized
     *         into EquipmentType
     * 
     * @see EquipmentType
     */
    public static HashMap<EquipmentType, ArrayList<RentalItem>> getItems() {
        Connection conn = DBManager.getConnection();
        Statement statement;
        HashMap<EquipmentType, ArrayList<RentalItem>> equipment = new HashMap<>();

        try {
            // the query to execute
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT A.*, B.RentalEquipmentTypeName, B.RentalEquipmentPrice FROM RentalEquipment A, RentalEquipmentTypes B WHERE A.equipmentType = B.rentalEquipmentTypeID ORDER BY A.equipmentType, A.equipmentSize");

            while (result.next()) { // while more results available grab each entity available
                int id = result.getInt("equipmentID");
                String name = result.getString("equipmentName");
                String equipmentSize = result.getString("equipmentSize");
                String sizeUnit = result.getString("equipmentSizeUnit");
                int availbility = result.getInt("equipmentAvailability");
                EquipmentType type = EquipmentType.valueOf(result.getString("RentalEquipmentTypeName"));
                int price = result.getInt("RentalEquipmentPrice");

                // creates a new RentalItem for each available itme from the database
                RentalItem rentalItem = new RentalItem(id, name, equipmentSize, sizeUnit, availbility, type, price);

                // if the equipment type exists in the Hashmap...
                if (equipment.keySet().contains(rentalItem.getEquipmentType())) {
                    // ...add the equipment to that type...
                    equipment.get(rentalItem.getEquipmentType()).add(rentalItem);
                } else {
                    /**
                     * ...else add the type to the HashMap as the key, and a new ArrayList, with the
                     * equipment as the value
                     */
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

    /**
     * writes to the database the new rental equipment that the logged in user has
     * rented
     * 
     * @param item
     * @throws Exception
     */
    public static void addRental(RentalItem item) throws Exception {

        Connection conn = DBManager.getConnection();

        PreparedStatement statement;
        // The statement to execute
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

    /**
     * 
     * @return An ArrayList of Strings with a list of rented out equipment by the
     *         user currently logged in
     */
    public static ArrayList<String> getRentals() {

        Connection conn = DBManager.getConnection();

        PreparedStatement statement;

        // reads the database for the current rental equipment that is hired by the
        // logged in user
        try {
            statement = conn.prepareStatement(
                    "SELECT A.rentalID, B.equipmentName FROM Rentals A, RentalEquipment B, Users C WHERE A.equipmentID = B.equipmentID AND C.userID = ?");

            statement.setInt(1, UserController.getLoggedIn().getID());
            ResultSet result = statement.executeQuery();

            ArrayList<String> rentedEquipment = new ArrayList<>();

            // while result has next, adds the rented equipment to the rented equipment
            // ArrayList
            while (result.next()) {
                rentedEquipment.add(result.getString("equipmentName"));
            }
            return rentedEquipment;
        } catch (SQLException e) {

            return new ArrayList<String>();
        }
    }
}