package com.group20.resortproject.equipment;

import java.util.ArrayList;
import java.util.HashMap;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;

public class RentalEquipmentController {

    private static HashMap<EquipmentType, ArrayList<RentalItem>> items;

    public static void initRentalEquipment() {
        items = RentalEquipmentModel.getItems();
    }

    public static HashMap<EquipmentType, ArrayList<RentalItem>> getItems() {
        return items;
    }

    public static void insertEquipment(RentalItem item) throws Exception {
        RentalEquipmentModel.addRental(item);
    }
}
