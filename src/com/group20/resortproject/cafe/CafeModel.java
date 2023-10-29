package com.group20.resortproject.cafe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.group20.resortproject.Model;
import com.group20.resortproject.utility.DBManager;

public class CafeModel extends Model {

    /**
     * 
     * @return a HashMap of items available in the Cafe organised into
     *         CafeCategories
     * 
     * @see CafeCategories
     */
    public static HashMap<CafeCategories, ArrayList<Item>> getItems() {
        // Setup the connection, statement and HashMap
        Connection conn = DBManager.getConnection();
        Statement statement;
        HashMap<CafeCategories, ArrayList<Item>> items = new HashMap<>();

        try {
            // The query to execute
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM CafeItems ORDER BY category, price");

            while (result.next()) { // Loop through each row in the results and convert to their required types
                int id = result.getInt("itemID");
                String name = result.getString("itemName");
                CafeCategories category = CafeCategories.valueOf(result.getString("category").toUpperCase());
                float price = result.getFloat("price");
                String description = result.getString("description");

                Item item = new Item(id, name, category, price, description);

                // If the item's category exists in the HashMap...
                if (items.keySet().contains(item.getCategory())) {
                    // ...add the item to that category...
                    items.get(item.getCategory()).add(item);
                } else {
                    /**
                     * ...else add the category to the HashMap, as the key, and a new ArrayList,
                     * with
                     * the item, as the value
                     */
                    ArrayList<Item> list = new ArrayList<>();
                    list.add(item);
                    items.put(item.getCategory(), list);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL error when getting Cafe Items\n" + e.getMessage(), "Fatal Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return items;
    }

}
