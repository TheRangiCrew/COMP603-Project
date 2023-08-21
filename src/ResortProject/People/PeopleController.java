package ResortProject.People;

import ResortProject.Data.XMLFile;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class PeopleController {

    private ArrayList<Person> people;
    private XMLFile file;

    public PeopleController() {
        this.people = new ArrayList<Person>();
        
        // Open and get "root" element of the specified XML file
        this.file = new XMLFile("./resources/People.xml");
        Element root = file.root;

        // Extract all the Person elements as a list from the root element
        NodeList peopleList = root.getElementsByTagName("People");

        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < peopleList.getLength(); i++) {
            // Element to parse
            Element element = (Element) peopleList.item(i);

            // Parsers for each element. Only parse as "primitive" types. 
            // Actual types will be converted in Person object constructor
            String id = XMLFile.getTextContent(element, "id");
            String firstName = XMLFile.getTextContent(element, "firstName");
            String lastName = XMLFile.getTextContent(element, "lastName");
            String dob = XMLFile.getTextContent(element, "dob");
            String email = XMLFile.getTextContent(element, "email");
            String phone = XMLFile.getTextContent(element, "phone");

            // Add Person to People HashSet
            people.add(new Person(id, firstName, lastName, dob, email, phone));
        }
    }
    
    /**
     * @return the people
     */
    public ArrayList<Person> getPeople() {
        return this.people;
    }
    
    public Person getPerson(String email, LocalDate dob) {
        for (Person person : people) {
            if (person.getEmail().equalsIgnoreCase(email) && person.getDob().isEqual(dob)) {
                return person;
            }
        }
        
        return null;
    }
    
    /**
     * Handles the saving of the people data to it's corresponding XML file.
     * This should only run at the end of the program
     * 
     * @return true if the data was successfully saved to disk, else false
     */
    public boolean close() {
        try {
            // Create a new XML Document to add our new data to
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create the parent <People> element
            Element peopleElement = document.createElement("People");
            // Add <People> element to the document
            document.appendChild(peopleElement);

            /**
             * Loop through each person in the array and parse it's properties
             * into the XML document under a <People> element for each item.
             * Each element has it's corresponding XML element created and
             * appended to it's parent <People>. The text contents is parsed from
             * it's type to a string and added to it's XML element.
             */
            for (Person person : people) {
                // <Person> element for each person
                Element personElement = document.createElement("Person");

                // Create an <id> XML element
                Element idElement = document.createElement("id");
                // Parse from type to a string and add the text to the XML element
                idElement.appendChild(document.createTextNode(person.getId()));
                // Append the element as a child of it's <Person> element
                personElement.appendChild(idElement);

                Element typeElement = document.createElement("firstName");
                typeElement.appendChild(document.createTextNode(person.getFirstName()));
                personElement.appendChild(typeElement);

                Element nameElement = document.createElement("lsatName");
                nameElement.appendChild(document.createTextNode(person.getLastName()));
                personElement.appendChild(nameElement);

                Element openingElement = document.createElement("dob");
                openingElement.appendChild(document.createTextNode(person.getDob().toString()));
                personElement.appendChild(openingElement);

                Element closingElement = document.createElement("email");
                closingElement.appendChild(document.createTextNode(person.getEmail()));
                personElement.appendChild(closingElement);

                Element statusElement = document.createElement("phone");
                statusElement.appendChild(document.createTextNode(person.getPhone()));
                personElement.appendChild(statusElement);

                // Add <Person> to the parent <People> element
                peopleElement.appendChild(personElement);
            }
            
            // Save the document to the XML file and close the stream
            file.saveClose(document);
        } catch (Exception e) {
            System.out.println("Failed to close the PeopleController. An error occurred");
            return false;
        }

        return true;
    }
}
