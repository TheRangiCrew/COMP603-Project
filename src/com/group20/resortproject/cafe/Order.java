package com.group20.resortproject.cafe;

import java.util.ArrayList;
import java.util.Observable;

import com.group20.resortproject.user.UserController;

/**
 * A Cafe order tracking the items, item quantities and total cost of the order
 */
public class Order extends Observable {

    /** Total number of items in the order */
    private int itemCount;
    private float total;
    private ArrayList<OrderItem> items;

    /**
     * A new order for the Cafe
     */
    public Order() {
        this.itemCount = 0;
        this.total = 0.0f;
        this.items = new ArrayList<>();
    }

    /**
     * 
     * @return the items in the order
     * 
     * @see OrderItem
     */
    public ArrayList<OrderItem> getItems() {
        return this.items;
    }

    /**
     * Adds an item to the order, incrementing the item's quantity in the order if
     * it already exists within the current order
     * 
     * @param item the Item to add
     * 
     * @see Item
     */
    public void add(Item item) {
        OrderItem orderItem = new OrderItem(item);

        int index = this.items.indexOf(orderItem);

        // If the item exists within the order...
        if (index != -1) {
            // ...increment the item's quantity within the order...
            orderItem = this.items.get(index);
            orderItem.increment();
        } else {
            // ...else add the item to the order
            this.items.add(orderItem);
        }

        // Modify the totals of the order
        this.itemCount++;
        this.total += item.getPrice();

        // Notify observers of this order
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Removes the item from the order
     * 
     * @param item     the Item to remove
     * @param quantity the number of the given item to remove from the order
     * 
     * @see Item
     */
    public void removeItem(OrderItem item, int quantity) {
        int index = this.items.indexOf(item);

        // If the item is not present within the order for some reason, just return
        if (index == -1) {
            return;
        }

        // If the quantity of the item is <= 1...
        if (this.items.get(index).getQuantity() <= 1) {
            // ...completely remove the item from the order...
            this.itemCount -= item.getQuantity();
            this.total -= item.getTotalCost();
            this.items.remove(index);
        } else {
            // ...else adjust the quantity of the item as given
            this.itemCount -= quantity;
            this.total -= item.getItem().getPrice() * quantity;
            this.items.get(index).remove(quantity);
        }

        // Notify observers of this order
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * 
     * @return total number of items in the order
     */
    public int getItemCount() {
        return this.itemCount;
    }

    /**
     * 
     * @return total price of the order
     */
    public float getTotal() {
        return this.total;
    }

    /**
     * Submit the order, charging the user
     * 
     * @throws Exception any errors that may arise while submitting the order
     */
    public void submit() throws Exception {
        try {
            UserController.getLoggedIn().chargeAccount(this.total);
        } catch (Exception e) {
            throw e;
        }
    }

}
