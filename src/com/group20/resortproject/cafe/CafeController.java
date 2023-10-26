package com.group20.resortproject.cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class CafeController {

    private static HashMap<CafeCategories, ArrayList<Item>> items;

    /**
     * Initialises the Cafe
     */
    public static void initCafe() {
        items = CafeModel.getItems();
    }

    public static HashMap<CafeCategories, ArrayList<Item>> getItems() {
        return items;
    }
}
