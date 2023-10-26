package com.group20.resortproject.cafe;

import java.util.ArrayList;
import java.util.Observable;

import com.group20.resortproject.user.UserController;

public class Order extends Observable {

    private int itemCount;
    private float total;
    private ArrayList<OrderItem> items;

    public Order() {
        this.itemCount = 0;
        this.total = 0.0f;
        this.items = new ArrayList<>();
    }

    public ArrayList<OrderItem> getItems() {
        return this.items;
    }

    public void add(Item item) {
        OrderItem orderItem = new OrderItem(item);

        int index = this.items.indexOf(orderItem);

        if (index != -1) {
            orderItem = this.items.get(index);
            orderItem.increment();
        } else {
            this.items.add(orderItem);
        }

        this.itemCount++;
        this.total += item.getPrice();

        this.setChanged();
        this.notifyObservers();
    }

    public void removeItem(OrderItem item, int quantity) {
        int index = this.items.indexOf(item);

        if (index == -1) {
            return;
        }

        if (this.items.get(index).getQuantity() <= 1) {
            this.itemCount -= item.getQuantity();
            this.total -= item.getTotalCost();
            this.items.remove(index);
        } else {
            this.itemCount -= quantity;
            this.total -= item.getItem().getPrice() * quantity;
            this.items.get(index).remove(quantity);
        }

        this.setChanged();
        this.notifyObservers();
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public float getTotal() {
        return this.total;
    }

    public void submit() throws Exception {
        try {
            UserController.getLoggedIn().chargeAccount(this.total);
        } catch (Exception e) {
            throw e;
        }
    }

}
