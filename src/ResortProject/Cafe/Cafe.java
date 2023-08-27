package ResortProject.Cafe;

import ResortProject.Data.XMLFile;
import ResortProject.Lifts.Lift;
import java.util.HashSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Cafe { 
    private HashSet<Item> cafeMenu;
    private XMLFile file;
    
    //Constructor
    public Cafe() {
        this.cafeMenu = new HashSet<Item>();
        
        //Open and get "root" element of the specified XML file
        file = new XMLFile("./resources/Cafe.xml");
        Element root = file.root;
        
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
    
    public boolean save() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element cafeElement = document.createElement("Cafe");
            document.appendChild(cafeElement);

            for (Item item : cafeMenu) {
                Element itemElement = document.createElement("Item");

                Element idElement = document.createElement("id");
                idElement.appendChild(document.createTextNode(item.getId().toString()));
                itemElement.appendChild(idElement);
                
                Element nameElement = document.createElement("name");
                nameElement.appendChild(document.createTextNode(item.getName()));
                itemElement.appendChild(nameElement);

                Element priceElement = document.createElement("price");
                priceElement.appendChild(document.createTextNode(String.valueOf(item.getPrice())));
                itemElement.appendChild(priceElement);

                Element descriptionElement = document.createElement("description");
                descriptionElement.appendChild(document.createTextNode(item.getDescription()));
                itemElement.appendChild(descriptionElement);

                // Add other elements similarly
                cafeElement.appendChild(itemElement);
                
                file.save(document);
            }
        } catch (Exception e) {
            System.out.println("Failed to close the LiftController. An error occurred");
            return false;
        }

        return true;
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
