package ResortProject.Cafe;

import ResortProject.Data.GlobalData;
import ResortProject.People.Person;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Order Class
 * 
 * Used to keep track of an order as it is being created by the user. Provides
 * methods for adding, removing and updating item information
 */
public class Order {

    /**
     * HashMap to store all the items added to the order. Each item is stored as a
     * key value pair where the key is the name of the item and the value is an
     * instance of that item. This way the total number of an item can be requested
     * and bulk quantities of an item can be removed
     */
    private HashMap<String, ArrayList<Item>> items;
    // Number of items in the order
    private int numOfItems;
    // Total cost of the order
    private float cost;

    /**
     * Constructor for a new order
     */
    public Order() {
        this.items = new HashMap<>();
        this.cost = 0.0f;
    }

    /**
     * Adds an item to the order
     * 
     * @param item Item to add to the order
     * @see Item
     */
    public void add(Item item) {
        // If the order already contains an item with that name...
        if (this.items.containsKey(item.getName())) {
            // ...add the item to the existing key and ArrayList
            items.get(item.getName()).add(item);
        } else {
            // ...else create a new ArrayList as a value and the item's name as a key and
            // put to the HashMap
            ArrayList<Item> list = new ArrayList<Item>();
            list.add(item);
            items.put(item.getName(), list);
        }
        // Add the item's cost to the total cost of the order
        this.cost += item.getPrice();
        // Increment the number of items in the order
        this.numOfItems++;
    }

    /**
     * Remove all instances of an Item from the order using its name as the key
     * 
     * @param name the name of the product to remove
     * @see Item
     */
    public void remove(String name) {
        // Find the item within the order
        ArrayList<Item> itemList = this.items.get(name);

        // Get the total price of all instances of that item and deduct from the total
        // order cost
        this.cost -= itemList.size() * itemList.get(0).getPrice();
        // Deduct the total number of items from the order's item count
        this.numOfItems -= itemList.size();

        // Remove the item from the order
        this.items.remove(name);
    }

    /**
     * Remove a given number of an Item from the order using its name as the key
     * 
     * @param name the name of the product to remove
     * @param num  the number of that item to remove
     * @see Item
     */
    public void remove(String name, int num) {
        // Find the item within the order
        ArrayList<Item> itemList = this.items.get(name);

        // Get the cost of the item multiplied by the provided quantity and subtract
        // that from the order's total cost
        this.cost -= num * itemList.get(0).getPrice();
        // Deduct the number of items from the order's item count
        this.numOfItems -= num;

        // Remove the specified number of Items from the order
        for (int i = 0; i < num; i++) {
            itemList.remove(i);
        }
    }

    /**
     * Submit the order and charge the currently logged in user that total for that
     * order
     * 
     * @return {@code true} if the user was charged successfully, otherwise
     *         {@code false}
     * @see Person
     */
    public boolean submit() {
        // Get the currently logged in user and charge them
        return GlobalData.getLoggedIn().deductFromCredit(cost);
    }

    /**
     * 
     * @return the total number of items in the order
     */
    public int getNumOfItems() {
        return this.numOfItems;
    }

    /**
     * 
     * @return the total cost of the order as a string (e.g. {@code $1.23})
     */
    public String getCostString() {
        // Decimal formatter
        DecimalFormat decformat = new DecimalFormat("0.00");

        // $ + the formatted cost as a String
        return "$" + decformat.format(this.cost);
    }

    /**
     * 
     * @return all the items in the order. The name of an item is the key and an
     *         ArrayList of Items is the value
     * @see Item
     */
    public HashMap<String, ArrayList<Item>> getItems() {
        return this.items;
    }

    /**
     * @return a string representation of the order that shows the quantity, name
     *         and cost of each item ordered followed by the total cost and number
     *         of items for the order
     */
    @Override
    public String toString() {
        String output = "";

        // Adding each item in the order to the output string formatted to show their
        // quantity, name and their price
        for (Entry<String, ArrayList<Item>> item : this.items.entrySet()) {
            output += (item.getValue().size() + "x " + item.getKey() + " @ " + item.getValue().get(0).getPriceString()
                    + "\n");
        }

        // Add the total number of items and total order cost to the output string
        output += "--------------------\nTotal " + this.numOfItems + (this.numOfItems == 1 ? " item - " : " items - ")
                + this.getCostString();

        return output;
    }

    /**
     * 
     * @return a string representation of the order that shows the quantity, name
     *         and cost of each item ordered, in a numerical list, followed by the
     *         total cost and number of items for the order
     */
    public String toListedString() {
        String output = "";

        int index = 1;
        // Add each item in the order to the output string formatted to show their
        // quantity, name and their price
        for (Entry<String, ArrayList<Item>> item : this.items.entrySet()) {
            output += (index + ".    " + item.getValue().size() + "x " + item.getKey() + " @ "
                    + item.getValue().get(0).getPriceString() + "\n");
            index++;
        }

        // Add the total number of items and total order cost to the output string
        output += "--------------------\nTotal " + this.numOfItems + (this.numOfItems == 1 ? " item - " : " items - ")
                + this.getCostString();

        return output;
    }

}
