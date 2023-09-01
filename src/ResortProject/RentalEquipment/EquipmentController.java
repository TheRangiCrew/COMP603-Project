package ResortProject.RentalEquipment;

import ResortProject.Data.XMLFile;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.*;

/**
 * Equipment Controller
 * 
 * Responsible for importing the data for the equipment from XML files and
 * parsing the data into collections to be used globally throughout the program
 */
public class EquipmentController {

    /**
     * Collection to store the different types of equipment where the equipment type
     * is the key and the variations/instances of each equipment type is the value
     */
    private HashMap<String, ArrayList<Equipment>> equipment;
    // The XML file to read and write to
    private XMLFile file;

    /**
     * Constructor
     */
    public EquipmentController() {
        this.equipment = new HashMap<>();

        // Open and get "root" element of the specified XML file
        this.file = new XMLFile("./resources/RentalEquipment.xml");
        Element root = file.getRoot();

        // Extract all the RentalEquipment elements as a list from the root element
        NodeList equipmentList = root.getElementsByTagName("Item");

        // Loop through NodeList and parse each necessary element
        for (int i = 0; i < equipmentList.getLength(); i++) {
            // The current element to parse
            Element element = (Element) equipmentList.item(i);

            // Gets the value of the type attribute for the current element
            String type = element.getAttribute("type");

            // Declaration of the equipment type
            ArrayList<Equipment> equipmentType;

            // If the HashMap has a key matching the type...
            if (equipment.containsKey(type)) {
                // get the value of that key as the array to put the current element into
                equipmentType = equipment.get(type);
            } else {
                // else add a new key-value pair to the HashMap where the key is the equipment's
                // type
                equipmentType = new ArrayList<Equipment>();
                equipment.put(type, equipmentType);
            }

            // Parses
            String name = element.getAttribute("type");
            String size = XMLFile.getTextContent(element, "size");
            int available = Integer.parseInt(XMLFile.getTextContent(element, "available"));

            Equipment newItem;

            // switch case on the type so it reads in any custome elemnts for that type.
            switch (type) {
                case "snowboard":
                    RideType rideType = RideType
                            .valueOf(XMLFile.getTextContent(element, "rideType").toUpperCase().replace(" ", "_"));
                    newItem = new Snowboard(size, available, rideType);
                    break;
                case "ski":
                    rideType = RideType
                            .valueOf(XMLFile.getTextContent(element, "rideType").toUpperCase().replace(" ", "_"));
                    newItem = new Skis(size, available, rideType);
                    break;
                case "boots":
                    BootType bootType = BootType.valueOf(XMLFile.getTextContent(element, "bootType").toUpperCase());
                    newItem = new Boots(size, available, bootType);
                    break;
                case "clothing":
                    String clothingType = XMLFile.getTextContent(element, "clothingType");
                    String gender = XMLFile.getTextContent(element, "gender");
                    newItem = new Clothing(clothingType, size, available, gender);
                    break;
                default:
                    newItem = new Equipment(type, size, available, type);
                    break;
            }

            equipmentType.add(newItem);
        }
    }

    /**
     * 
     * @return all the stored equipment where the equipment type
     *         is the key and the variations/instances of each equipment type is the
     *         value
     */
    public HashMap<String, ArrayList<Equipment>> getEquipment() {
        return this.equipment;
    }

    /**
     * @return all the snowboards
     */
    public ArrayList<Snowboard> getSnowboards() {
        // Empty ArrayList of snowboards
        ArrayList<Snowboard> snowboards = new ArrayList<>();
        // Loop through each snowboard in the equipment HashMap
        this.equipment.get("snowboard").forEach((Equipment element) -> {
            // Add to the snowboards ArrayList
            snowboards.add((Snowboard) element);
        });

        // Return the ArrayList
        return snowboards;
    }

    /**
     * 
     * @return all the skis
     */
    public ArrayList<Skis> getSkis() {
        // Empty ArrayList of skis
        ArrayList<Skis> skis = new ArrayList<>();
        // Loop through each skis in the equipment HashMap
        this.equipment.get("ski").forEach((Equipment element) -> {
            // Add to the skis ArrayList
            skis.add((Skis) element);
        });

        // Return the ArrayList
        return skis;
    }

    /**
     * 
     * @return all the skis
     */
    public ArrayList<Boots> getBoots() {
        // Empty ArrayList of boots
        ArrayList<Boots> boots = new ArrayList<>();
        // Loop through each boots in the equipment HashMap
        this.equipment.get("boots").forEach((Equipment element) -> {
            // Add to the boots ArrayList
            boots.add((Boots) element);
        });

        // Return the ArrayList
        return boots;
    }

    /**
     * 
     * @return all the skis
     */
    public ArrayList<Clothing> getClothing() {
        // Empty ArrayList of clothing
        ArrayList<Clothing> clothing = new ArrayList<>();
        // Loop through each clothing in the equipment HashMap
        this.equipment.get("clothing").forEach((Equipment element) -> {
            // Add to the clothing ArrayList
            clothing.add((Clothing) element);
        });

        // Return the ArrayList
        return clothing;
    }
}
