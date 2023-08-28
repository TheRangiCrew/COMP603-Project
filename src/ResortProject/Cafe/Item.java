package ResortProject.Cafe;

import java.text.DecimalFormat;

public class Item {

    private float price;
    private String name;
    private String description;
    private String category;

    public Item(String name, float price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public float getPrice() {
        return this.price;
    }
    
    public String getPriceString() {
        DecimalFormat decformat = new DecimalFormat("0.00");
        
        return "$" + decformat.format(this.price);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    @Override
    public String toString() {
        DecimalFormat decformat = new DecimalFormat("0.00");
        
        return this.name + "   " + this.getPriceString() + "\n" + this.description + "\n";
    }
}
