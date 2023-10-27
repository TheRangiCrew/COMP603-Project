package com.group20.resortproject.cafe;

/**
 * An Item as it would appear within the order. Tracking a specific item's
 * quantity and cost within the order
 * 
 * @see Order
 * @see Item
 */
public class OrderItem {

    private Item item;
    private int quantity;
    private float totalCost;

    /**
     * 
     * @param item Item to track
     * 
     * @see Item
     */
    public OrderItem(Item item) {
        this.item = item;
        this.quantity = 1;
        this.totalCost = this.item.getPrice();
    }

    /**
     * 
     * @return the Item
     * 
     * @see Item
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * 
     * @return the quantity of this item within the order
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * 
     * @return the total cost of this item within the order
     */
    public float getTotalCost() {
        return this.totalCost;
    }

    /**
     * Increment the quantity and add the price of the item to the total
     */
    public void increment() {
        this.quantity++;
        this.totalCost = this.item.getPrice() * this.quantity;
    }

    /**
     * Remove the specified quantity of this item from the order
     * 
     * @param number the quantity to remove
     */
    public void remove(int number) {
        this.quantity -= number;
        this.totalCost = this.item.getPrice() * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof OrderItem)) {
            return false;
        }

        OrderItem orderItem = (OrderItem) obj;

        return this.item.equals(orderItem.getItem());
    }

}
