package ResortProject.Cafe;

public class Item {

    private double price;
    private String name;
    private String description;

    public Item(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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
        return this.name + "\n$" + this.price + "\n" + this.description + "\n";
    }
}
