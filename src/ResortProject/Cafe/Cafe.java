package ResortProject.Cafe;

import ResortProject.Data.XMLFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Cafe Controller
 * 
 * Responsible for importing the data for the cafe from XML files and parsing
 * the data into collections to be used globally throughout the program
 */
public class Cafe {

    // Collection storing Items that are available within the cafe
    private HashMap<String, ArrayList<Item>> cafeMenu;
    // The XML file to read and write to
    private XMLFile file;

    /**
     * Constructor
     */
    public Cafe() {
        this.cafeMenu = new HashMap<>();

        // Open and get "root" element of the specified XML file. Root element is the
        // first element within the file
        file = new XMLFile("./resources/Cafe.xml");
        Element root = file.root;

        // Extract all the Item elements as a list of XML Nodes
        NodeList itemList = root.getElementsByTagName("Item");

        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < itemList.getLength(); i++) {
            // THe current element that will be parsed
            Element element = (Element) itemList.item(i);

            // Get the category attribute of the item
            String category = element.getAttribute("category");

            // The ArrayList to store the item's category if it doesn't exist
            ArrayList<Item> categoryList;

            // If a category already exists in the Cafe HashMap...
            if (cafeMenu.containsKey(category)) {
                // ...access the category form the HashMap
                categoryList = cafeMenu.get(category);
            } else {
                // ...else put an empty ArrayList into the HashMap with the category name as the
                // key
                categoryList = new ArrayList<Item>();
                cafeMenu.put(category, categoryList);
            }

            // Parse the elements as their primitive types or String to be converted later
            // Parsing name, price and description of items
            String name = XMLFile.getTextContent(element, "name");
            float price = Float.parseFloat(XMLFile.getTextContent(element, "price"));
            String description = XMLFile.getTextContent(element, "description");

            // Create and add the Item to cafeMenu HashMap
            categoryList.add(new Item(name, price, description, category));
        }

    }

    /**
     * 
     * @return all the Items in the menu
     * @see Item
     */
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
