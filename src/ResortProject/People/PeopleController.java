package ResortProject.People;

import ResortProject.Data.GlobalData;
import ResortProject.Data.XMLFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * People Controller
 * 
 * Responsible for importing the data for the people from XML files and parsing
 * the data into collections to be used globally throughout the program
 */
public class PeopleController {

    // Collection storing Persons
    private ArrayList<Person> people;
    // The XML file to read and write to
    private XMLFile file;

    public PeopleController() {
        this.people = new ArrayList<>();

        // Open and get "root" element of the specified XML file
        this.file = new XMLFile("./resources/People.xml");
        Element root = file.getRoot();

        // Extract all the Person elements as a list from the root element
        NodeList peopleList = root.getElementsByTagName("Person");

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
            float credit = Float.parseFloat(XMLFile.getTextContent(element, "credit"));

            HashSet<LiftPass> liftSet = new HashSet();
            NodeList liftPassElements = element.getElementsByTagName("LiftPasses");
            Element liftPassElement = (Element) liftPassElements.item(0);
            NodeList passElements = liftPassElement.getElementsByTagName("LiftPass");

            for (int j = 0; j < passElements.getLength(); j++) {
                Element passElement = (Element) passElements.item(j);

                String liftId = XMLFile.getTextContent(passElement, "id");
                String validFrom = XMLFile.getTextContent(passElement, "validFrom");
                String validTo = XMLFile.getTextContent(passElement, "validTo");

                liftSet.add(new LiftPass(liftId, validFrom, validTo));
            }

            // Add Person to People HashSet
            people.add(new Person(id, firstName, lastName, dob, email, phone, credit, liftSet));
        }
    }

    /**
     * @return the people
     */
    public ArrayList<Person> getPeople() {
        return this.people;
    }

    /**
     * Compares the email and date of birth of each person to find a specific person
     * 
     * @param email the email of the person
     * @param dob   the dob of the person as a LocalDate
     * @return a Person if one exists, or null if one cannot be found
     * @see LocalDate
     */
    public Person getPerson(String email, LocalDate dob) {
        for (Person person : people) {
            if (person.getEmail().equalsIgnoreCase(email) && person.getDob().equals(dob)) {
                return person;
            }
        }

        return null;
    }

    public Person addPerson(Person person) {
        this.people.add(person);
        GlobalData.save();

        return person;
    }

    /**
     * Handles the saving of the people data to it's corresponding XML file.
     * This should only run at the end of the program
     * 
     * @return true if the data was successfully saved to disk, else false
     */
    public boolean save() {
        if (this.people.isEmpty()) {
            return false;
        }
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

                Element firstNameElement = document.createElement("firstName");
                firstNameElement.appendChild(document.createTextNode(person.getFirstName()));
                personElement.appendChild(firstNameElement);

                Element lastNameElement = document.createElement("lastName");
                lastNameElement.appendChild(document.createTextNode(person.getLastName()));
                personElement.appendChild(lastNameElement);

                Element dobElement = document.createElement("dob");
                dobElement.appendChild(document.createTextNode(person.getDob().toString()));
                personElement.appendChild(dobElement);

                Element emailElement = document.createElement("email");
                emailElement.appendChild(document.createTextNode(person.getEmail()));
                personElement.appendChild(emailElement);

                Element phoneElement = document.createElement("phone");
                phoneElement.appendChild(document.createTextNode(person.getPhone()));
                personElement.appendChild(phoneElement);

                Element creditElement = document.createElement("credit");
                creditElement.appendChild(document.createTextNode(String.valueOf(person.getCredit())));
                personElement.appendChild(creditElement);

                Element passesElement = document.createElement("LiftPasses");
                for (LiftPass pass : person.getPasses()) {
                    Element passElement = document.createElement("LiftPass");

                    Element passIdElement = document.createElement("id");
                    passIdElement.appendChild(document.createTextNode(pass.getId().toString()));
                    passElement.appendChild(passIdElement);

                    Element validFromElement = document.createElement("validFrom");
                    validFromElement.appendChild(document.createTextNode(pass.getValidFrom().toString()));
                    passElement.appendChild(validFromElement);

                    Element validToElement = document.createElement("validTo");
                    validToElement.appendChild(document.createTextNode(pass.getValidTo().toString()));
                    passElement.appendChild(validToElement);

                    passesElement.appendChild(passElement);
                }

                personElement.appendChild(passesElement);

                // Add <Person> to the parent <People> element
                peopleElement.appendChild(personElement);
            }

            // Save the document to the XML file and close the stream
            file.save(document);
        } catch (Exception e) {
            System.out.println("Failed to close the PeopleController. An error occurred");
            return false;
        }

        return true;
    }

    /**
     * @return a list of people's names
     */
    @Override
    public String toString() {
        String output = "";

        for (Person person : people) {
            output += person.toString();
        }

        return output;
    }
}
