package com.group20.resortproject.cafe;

public class Item {

    private int ID;
    private String name;
    private CafeCategories category;
    private float price;
    private String description;

    public Item(int ID, String name, CafeCategories category, float price, String description) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public CafeCategories getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;

        return this.ID == item.ID;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
