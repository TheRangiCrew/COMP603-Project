package ResortProject.Lifts;

import ResortProject.Data.XMLFile;
import java.util.ArrayList;
import java.util.UUID;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Lift Controller
 * 
 * Responsible for importing the data for the lifts from XML files and parsing
 * the data into collections to be used globally throughout the program
 */
public class LiftController {

    // Collection storing Lift objects
    private ArrayList<Lift> lifts;
    // The XML file to read and write to
    private XMLFile file;

    /**
     * Constructor
     */
    public LiftController() {

        this.lifts = new ArrayList<Lift>();

        // Open and get "root" element of the specified XML file. Root element is the
        // first element within the file
        this.file = new XMLFile("./resources/Lift.xml");
        Element root = file.getRoot();

        // Extract all the Lift elements as a list from the root element
        NodeList liftList = root.getElementsByTagName("Lift");

        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < liftList.getLength(); i++) {
            // The current element that will be parsed
            Element element = (Element) liftList.item(i);

            // Parsers for each element. Only parse as "primitive" types.
            // Actual types will be converted in Lift object constructor
            String id = XMLFile.getTextContent(element, "id");
            int length = Integer.parseInt(XMLFile.getTextContent(element, "length"));
            int capacity = Integer.parseInt(XMLFile.getTextContent(element, "capacity"));
            String type = XMLFile.getTextContent(element, "type");
            String name = XMLFile.getTextContent(element, "name");
            String openingTime = XMLFile.getTextContent(element, "openingTime");
            String closingTime = XMLFile.getTextContent(element, "closingTime");
            String status = XMLFile.getTextContent(element, "status");

            // Add Lift to lifts ArrayList
            lifts.add(new Lift(id, length, capacity, type, name, openingTime, closingTime, status));
        }

    }

    /**
     * 
     * @return all the lifts
     */
    public ArrayList<Lift> getLifts() {
        return this.lifts;
    }

    /**
     * Find a lift with the specified name
     * 
     * @param name the name of the lift
     * @return the Lift object if found else {@code null}
     * @see Lift
     */
    public Lift getLift(String name) {
        // Loop through each lift and compare their names ingoring case
        for (Lift lift : lifts) {
            if (lift.getName().equalsIgnoreCase(name)) {
                return lift;
            }
        }

        return null;
    }

    /**
     * Find a lift with the specified UUID
     * 
     * @param id the UUID of the lift
     * @return the Lift object if found else {@code null}
     * @see Lift
     * @see UUID
     */
    public Lift getLift(UUID id) {
        // Loop through each lift and compare their UUIDs
        for (Lift lift : lifts) {
            if (lift.getId().compareTo(id) == 0) {
                return lift;
            }
        }

        return null;
    }

    /**
     * Handles the saving of the lift data to it's corresponding XML file.
     * 
     * @return true if the data was successfully saved to disk, else false
     */
    public boolean save() {
        if (this.lifts.isEmpty()) {
            return false;
        }
        try {
            // Create a new XML Document to add our new data to
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create the parent <Lifts> element
            Element liftsElement = document.createElement("Lifts");
            // Add <Lifts> element to the document
            document.appendChild(liftsElement);

            /**
             * Loop through each lift in the array and parse it's properties
             * into the XML document under a <Lift> element for each item.
             * Each element has it's corresponding XML element created and
             * appended to it's parent <Lift>. The text contents is parsed from
             * it's type to a string and added to it's XML element.
             */
            for (Lift lift : lifts) {
                // <Lift> element for each lift
                Element liftElement = document.createElement("Lift");

                // Create an <id> XML element
                Element idElement = document.createElement("id");
                // Parse from type to a string and add the text to the XML element
                idElement.appendChild(document.createTextNode(lift.getId().toString()));
                // Append the element as a child of it's <Lift> element
                liftElement.appendChild(idElement);
                // Repeat for each element
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

                // Add <Lift> to the parent <Lifts> element
                liftsElement.appendChild(liftElement);
            }

            // Save the document to the XML file and close the stream
            file.save(document);
        } catch (Exception e) {
            System.out.println("Failed to close the LiftController. An error occurred");
            return false;
        }

        return true;
    }

    /**
     * @return a list of all the lifts generate using their {@code toString()}
     *         methods
     * @see Lift
     */
    @Override
    public String toString() {
        String output = "";

        for (Lift lift : lifts) {
            output += lift.toString() + "\n";
        }

        return output;
    }
}
