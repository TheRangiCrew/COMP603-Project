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
        XMLFile inputFile = new XMLFile("Lift.xml");
        Element root = inputFile.root;
        
        // Extract all the Lift elements as a list from the root element
        NodeList liftList = root.getElementsByTagName("Lift");
        
        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < liftList.getLength(); i++) {
            // Element to parse
            Element element = (Element) liftList.item(i);
            
            // Parsers
            String id = element.getAttribute("id");
            int length = Integer.parseInt(element.getAttribute("length"));
            int capacity = Integer.parseInt(element.getAttribute("capacity"));
            String type = element.getAttribute("type");
            String name = element.getAttribute("name");
            String openingTime = element.getAttribute("openingTime");
            String closingTime = element.getAttribute("closingTime");
            String status = element.getAttribute("status");
            
            // Add Lift to lifts HashSet
            lifts.add(new Lift(id, length, capacity, type, name, openingTime, closingTime, status));
        }
        
    }
    
    public HashSet<Lift> getLifts() {
        return this.lifts;
    }
 }
