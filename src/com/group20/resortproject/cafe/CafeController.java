package com.group20.resortproject.cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class CafeController {

    /**
     * A HashMap of items available in the cafe. A sort of digital menu. Sorted into
     * CafeCategories
     * 
     * @see CafeCategories
     */
    private static HashMap<CafeCategories, ArrayList<Item>> items;

    /**
     * Initialises the Cafe
     */
    public static void initCafe() {
        items = CafeModel.getItems();
    }

    /**
     * 
     * @return a HashMap of items available in the Cafe organised into
     *         CafeCategories
     * 
     * @see CafeCategories
     */
    public static HashMap<CafeCategories, ArrayList<Item>> getItems() {
        return items;
    }
}
