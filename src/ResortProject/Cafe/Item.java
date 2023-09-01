package ResortProject.Cafe;

import java.text.DecimalFormat;

/**
 * Item Class
 * 
 * The attributes and methods for all items in the Cafe's menu
 */
public class Item {

    private float price;
    private String name;
    private String description;
    private String category;

    /**
     * 
     * @param name        name of the item
     * @param price       items price as a {@code float}
     * @param description item's description
     * @param category    item's category as a {@code String}
     */
    public Item(String name, float price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    /**
     * 
     * @return the item's price as a {@code float}
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * String representation of the item's price
     * 
     * @return the price formatted (e.g. {@ $1.23})
     */
    public String getPriceString() {
        // Formatter for the float formatting it to two decimal places
        DecimalFormat decformat = new DecimalFormat("0.00");

        // $ + the formatted price
        return "$" + decformat.format(this.price);
    }

    /**
     * 
     * @return item's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return item's description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @return item's category as a {@code String}
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * @return string representation of an item with its name, formatted price and
     *         description
     */
    @Override
    public String toString() {
        return this.name + "   " + this.getPriceString() + "\n" + this.description + "\n";
    }
}
