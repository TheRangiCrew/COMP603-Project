package ResortProject.Lifts;

import ResortProject.Data.XMLFile;
import java.util.HashSet;
import java.util.UUID;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author ryanz
 */
public class LiftController {

    private HashSet<Lift> lifts = new HashSet<Lift>();

    // Constructor reads in the current data from the Lift XML file
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

    public Lift getLift(String name) {
        for (Lift lift : lifts) {
            if (lift.getName().equalsIgnoreCase(name)) {
                return lift;
            }
        }

        return null;
    }

    public Lift getLift(UUID id) {
        for (Lift lift : lifts) {
            if (lift.getId().compareTo(id) == 0) {
                return lift;
            }
        }

        return null;
    }

    public boolean close() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element liftsElement = document.createElement("Lifts");
        document.appendChild(liftsElement);

        for (Lift lift : lifts) {
            Element liftElement = document.createElement("Lift");

            Element idElement = document.createElement("id");
            idElement.appendChild(document.createTextNode(lift.getId().toString()));
            liftElement.appendChild(idElement);

            Element lengthElement = document.createElement("length");
            lengthElement.appendChild(document.createTextNode(String.valueOf(lift.getLength())));
            liftElement.appendChild(lengthElement);

            // Add other elements similarly
            liftsElement.appendChild(liftElement);
        }
        
        return true;
    }

    @Override
    public String toString() {
        String output = "";

        for (Lift lift : lifts) {
            output += lift.toString() + "\n";
        }

        return output;
    }
}
