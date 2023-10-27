package com.group20.resortproject.cafe;

/**
 * An Item that can be purchased at the Cafe
 */
public class Item {

    private int ID;
    private String name;
    private CafeCategories category;
    private float price;
    private String description;

    /**
     * 
     * @param ID          Item ID
     * @param name        Item name
     * @param category    Item category
     * @param price       Item price
     * @param description Item descirption
     * 
     * @see CafeCategories
     */
    public Item(int ID, String name, CafeCategories category, float price, String description) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    /**
     * 
     * @return the item's unique ID
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the item's category
     * 
     * @see CafeCategories
     */
    public CafeCategories getCategory() {
        return category;
    }

    /**
     * 
     * @return the item's price
     */
    public float getPrice() {
        return price;
    }

    /**
     * 
     * @return the item's description
     */
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
