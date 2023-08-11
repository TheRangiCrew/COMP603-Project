package ResortProject.Cafe;

import java.util.UUID;

public class Item {

    private UUID id;
    private double price;
    private String name;
    private String description;

    public Item(UUID id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public Item(String name, double price, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public UUID getId() {
        return this.id;
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
