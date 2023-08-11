package ResortProject.Cafe;

public class Item {

    private float price;
    private String name;
    private String description;

    public Item(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
