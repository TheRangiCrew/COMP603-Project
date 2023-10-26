package com.group20.resortproject.cafe;

public class OrderItem {

    private Item item;
    private int quantity;
    private float totalCost;

    public OrderItem(Item item) {
        this.item = item;
        this.quantity = 1;
        this.totalCost = this.item.getPrice();
    }

    public Item getItem() {
        return this.item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public float getTotalCost() {
        return this.totalCost;
    }

    public void increment() {
        this.quantity++;
        this.totalCost = this.item.getPrice() * this.quantity;
    }

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
