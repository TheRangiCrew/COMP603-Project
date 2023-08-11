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

    private HashSet<Lift> lifts;
    private XMLFile file;

    // Constructor reads in the current data from the Lift XML file
    public LiftController() {
        
        this.lifts = new HashSet<Lift>();
        
        // Open and get "root" element of the specified XML file
        this.file = new XMLFile("./resources/Lift.xml");
        Element root = file.root;

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
        try {
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

                Element capacityElement = document.createElement("capacity");
                capacityElement.appendChild(document.createTextNode(String.valueOf(lift.getCapacity())));
                liftElement.appendChild(capacityElement);

                Element typeElement = document.createElement("type");
                typeElement.appendChild(document.createTextNode(lift.getType().name()));
                liftElement.appendChild(typeElement);

                Element nameElement = document.createElement("name");
                nameElement.appendChild(document.createTextNode(lift.getName()));
                liftElement.appendChild(nameElement);

                Element openingElement = document.createElement("openingTime");
                openingElement.appendChild(document.createTextNode(lift.getOpeningTime().toString()));
                liftElement.appendChild(openingElement);

                Element closingElement = document.createElement("closingTime");
                closingElement.appendChild(document.createTextNode(lift.getClosingTime().toString()));
                liftElement.appendChild(closingElement);

                Element statusElement = document.createElement("status");
                statusElement.appendChild(document.createTextNode(lift.getStatus().name()));
                liftElement.appendChild(statusElement);

                // Add other elements similarly
                liftsElement.appendChild(liftElement);
                
                file.saveClose(document);
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

        for (Lift lift : lifts) {
            output += lift.toString() + "\n";
        }

        return output;
    }
}
