package ResortProject.Cafe;

import ResortProject.People.Person;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Order {
    
    private HashMap<String, ArrayList<Item>> items;
    private int numOfItems;
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
        this.cost += item.getPrice();
        this.numOfItems++;
    }
    
    public void remove(String name) {
        ArrayList<Item> itemList = this.items.get(name);
        
        this.cost -= itemList.size() * itemList.get(0).getPrice();
        this.numOfItems -= itemList.size();
        
        this.items.remove(name);
    }
    
    public void remove(String name, int num) {
        ArrayList<Item> itemList = this.items.get(name);
        
        this.cost -= num * itemList.get(0).getPrice();
        this.numOfItems -= num;
        
        for (int i = 0; i < num; i++) {
            itemList.remove(i);
        }
    }
    
    public boolean submit(Person person) {
        if (person.getCredit() < this.cost) {
            return false;
        }
        
        person.deductFromCredit(cost);
        
        return true;
    }
    
    public int getNumOfItems() {
        return this.numOfItems;
    }
    
    public String getCostString() {
        DecimalFormat decformat = new DecimalFormat("0.00");
        
        return "$" + decformat.format(this.cost);
    }
    
    public HashMap<String, ArrayList<Item>> getItems() {
        return this.items;
    }
    
    @Override
    public String toString() {
        String output = "";
        
        for (Entry<String, ArrayList<Item>> item : this.items.entrySet()) {
            output += (item.getValue().size() + "x " + item.getKey() + " @ " + item.getValue().get(0).getPriceString() + "\n");
        }
        
        output += "--------------------\nTotal " + this.numOfItems + (this.numOfItems == 1 ? " item - " : " items - ") + this.getCostString();
        
        return output;
    }
    
    public String toListedString() {
        String output = "";
        
        int index = 1;
        for (Entry<String, ArrayList<Item>> item : this.items.entrySet()) {
            output += (index + ".    " + item.getValue().size() + "x " + item.getKey() + " @ " + item.getValue().get(0).getPriceString() + "\n");
            index++;
        }
        
        output += "--------------------\nTotal " + this.numOfItems + (this.numOfItems == 1 ? " item - " : " items - ") + this.getCostString();
        
        return output;
    }
    
}
