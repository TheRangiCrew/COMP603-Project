package com.group20.resortproject.cafe;

public enum CafeCategories {
    BREAKFAST("Breakfast"),
    LUNCH_DINNER("Lunch/Dinner"),
    DRINKS("Drinks");

    private String name;

    private CafeCategories(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static CafeCategories findFromString(String string) {
        return CafeCategories.valueOf(string);
    }
}
