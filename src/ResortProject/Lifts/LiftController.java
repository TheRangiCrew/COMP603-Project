package ResortProject.Lifts;

import ResortProject.Data.XMLFile;
import java.util.HashSet;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author ryanz
 */
public class LiftController {
    private HashSet lifts = new HashSet<Lift>();
    
    // Constructor
    public LiftController() {
        // Open and get "root" element of the specified XML file
        XMLFile inputFile = new XMLFile("./resources/Lift.xml");
        Element root = inputFile.root;
        
        // Extract all the Lift elements as a list from the root element
        NodeList liftList = root.getElementsByTagName("Lift");
        
        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < liftList.getLength(); i++) {
            // Element to parse
            Element element = (Element) liftList.item(i);
            
            // Parsers
            String id = XMLFile.getTextContent(element, "id");
            System.out.println(id);
            int length = Integer.parseInt(XMLFile.getTextContent(element, "length"));
            int capacity = Integer.parseInt(XMLFile.getTextContent(element, "capacity"));
            String type = XMLFile.getTextContent(element, "type");
            String name = XMLFile.getTextContent(element, "name");
            String openingTime = XMLFile.getTextContent(element, "openingTime");
            String closingTime = XMLFile.getTextContent(element, "closingTime");
            String status = XMLFile.getTextContent(element, "status");
            
            // Add Lift to lifts HashSet
            lifts.add(new Lift(id, length, capacity, type, name, openingTime, closingTime, status));
        }
        
    }
    
    public HashSet<Lift> getLifts() {
        return this.lifts;
    }
    
    @Override
    public String toString() {
        String output = "";
        
        for (Object lift: lifts) {
            output += lift.toString() + "\n";
        }
        
        return output;
    }
 }
