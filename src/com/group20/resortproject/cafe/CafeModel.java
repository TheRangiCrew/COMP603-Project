package com.group20.resortproject.cafe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.group20.resortproject.Model;
import com.group20.resortproject.utility.DBManager;

public class CafeModel extends Model {

    public static HashMap<CafeCategories, ArrayList<Item>> getItems() {
        Connection conn = DBManager.getConnection();
        Statement statement;
        HashMap<CafeCategories, ArrayList<Item>> items = new HashMap<>();

        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM CafeItems ORDER BY category, price");

            while (result.next()) {
                int id = result.getInt("itemID");
                String name = result.getString("itemName");
                CafeCategories category = CafeCategories.findFromString(result.getString("category"));
                float price = result.getFloat("price");
                String description = result.getString("description");

                Item item = new Item(id, name, category, price, description);

                if (items.keySet().contains(item.getCategory())) {
                    items.get(item.getCategory()).add(item);
                } else {
                    ArrayList<Item> list = new ArrayList<>();
                    list.add(item);
                    items.put(item.getCategory(), list);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

}
