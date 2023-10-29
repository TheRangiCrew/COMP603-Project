package com.group20.resortproject.equipment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class RentalEquipmentController {

    private static HashMap<EquipmentType, ArrayList<RentalItem>> items;

    /**
     * Initiates the rentalEquipmentModel
     */
    public static void initRentalEquipment() {
        items = RentalEquipmentModel.getItems();
    }

    /**
     * 
     * @return a hashMap of RentalItems
     */
    public static HashMap<EquipmentType, ArrayList<RentalItem>> getItems() {
        return items;
    }

    /**
     * 
     * @param item the item to insert
     * @throws Exception
     */
    public static void insertEquipment(RentalItem item) throws Exception {
        RentalEquipmentModel.addRental(item);
    }
}
