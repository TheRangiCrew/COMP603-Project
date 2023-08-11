package ResortProject.Cafe;

import ResortProject.Data.XMLFile;
import java.util.HashSet;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Cafe { 
    private HashSet<Item> cafeMenu = new HashSet<Item>();
    
    //Constructor
    public Cafe() {
        //Open and get "root element of the specified XML file
        XMLFile inputFile = new XMLFile("./resources/Cafe.xml");
        Element root = inputFile.root;
        
        //Extract all the Lift elements as a list from the root element
        NodeList itemList = root.getElementsByTagName("Item");
        
        //Loop through NodeList and parse each necessary element 
        for (int i = 0; i < itemList.getLength(); i++) {
            //Element to parse
            Element element = (Element) itemList.item(i);
            
            //Parses
            String name = XMLFile.getTextContent(element, "name");
            double price = Double.parseDouble(XMLFile.getTextContent(element, "price"));
            String description = XMLFile.getTextContent(element, "description");
            
            //Add Item to cafeMenu HashSet
            cafeMenu.add(new Item(name, price, description));
        }
    }
    
    public HashSet<Item> getCafeMenu() {
        return this.cafeMenu;
    }
    
    @Override
    public String toString() {
        String output = "";
        
        // Calling each item and adding it's toString
        for (Item item: cafeMenu) {
            output += item.toString() + "\n";
        }
        
        return output;
    }
}
