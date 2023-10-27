package com.group20.resortproject.cafe;

/**
 * Possible categories for items in the cafe to belong to
 */
public enum CafeCategories {
    BREAKFAST("Breakfast"),
    LUNCH_DINNER("Lunch/Dinner"),
    DRINKS("Drinks");

    private String name;

    /**
     * 
     * @param name human readable name
     */
    private CafeCategories(String name) {
        this.name = name;
    }

    /**
     *
     * @return a user-friendly name for the category
     */
    public String getName() {
        return this.name;
    }
}
