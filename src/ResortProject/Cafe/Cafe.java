package ResortProject.Cafe;

import ResortProject.Data.XMLFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Cafe {

    private HashMap<String, ArrayList<Item>> cafeMenu;
    private XMLFile file;

    //Constructor
    public Cafe() {
        this.cafeMenu = new HashMap<>();

        //Open and get "root" element of the specified XML file
        file = new XMLFile("./resources/Cafe.xml");
        Element root = file.root;

        //Extract all the Lift elements as a list from the root element
        NodeList itemList = root.getElementsByTagName("Item");

        //Loop through NodeList and parse each necessary element 
        for (int i = 0; i < itemList.getLength(); i++) {
            //Element to parse
            Element element = (Element) itemList.item(i);

            String category = element.getAttribute("category");

            ArrayList<Item> categoryList;

            if (cafeMenu.containsKey(category)) {
                categoryList = cafeMenu.get(category);
            } else {
                categoryList = new ArrayList<Item>();
                cafeMenu.put(category, categoryList);
            }

            //Parses
            String name = XMLFile.getTextContent(element, "name");
            float price = Float.parseFloat(XMLFile.getTextContent(element, "price"));
            String description = XMLFile.getTextContent(element, "description");

            //Add Item to cafeMenu HashSet
            categoryList.add(new Item(name, price, description, category));
        }

    }

    public HashMap<String, ArrayList<Item>> getMenu() {
        return this.cafeMenu;
    }
    
    @Override
    public String toString() {
        String output = "";

        // Calling each item and adding it's toString
        for (Entry<String, ArrayList<Item>> items : cafeMenu.entrySet()) {
            output += items.getKey() + "\n";
            output += "--------------------\n";

            for (Item item : items.getValue()) {
                output += item.toString() + "\n";
            }
        }

        return output;
    }
}
