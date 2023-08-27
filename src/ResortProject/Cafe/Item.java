package ResortProject.Cafe;

import java.text.DecimalFormat;

public class Item {

    private double price;
    private String name;
    private String description;
    private String category;

    public Item(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        DecimalFormat decformat = new DecimalFormat("0.00");
        
        return this.name + "   $" + decformat.format(this.price) + "\n" + this.description + "\n";
    }
}
