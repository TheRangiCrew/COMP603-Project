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
    
    public void add(Item item) {
        if (this.items.containsKey(item.getName())) {
            items.get(item.getName()).add(item);
        } else {
            ArrayList<Item> list = new ArrayList<Item>();
            list.add(item);
            items.put(item.getName(), list);
        }
        cost += item.getPrice();
    }
    
    public void remove(String name) {
        
    }
    
}
