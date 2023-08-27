package ResortProject.Cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    
    private HashMap<String, ArrayList<Item>> items;
    private float cost;
    
    public Order() {
        this.items = new HashMap<>();
        this.cost = 0.0f;
    }
    
}
