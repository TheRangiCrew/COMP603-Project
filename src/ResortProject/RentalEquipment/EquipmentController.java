package ResortProject.RentalEquipment;

import ResortProject.Data.XMLFile;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class EquipmentController {

    private HashMap<String, ArrayList<Equipment>> equipment;
    private XMLFile file;

    public EquipmentController() {
        this.equipment = new HashMap<>();

        // Open and get "root" element of the specified XML file
        this.file = new XMLFile("./resources/RentalEquipment.xml");
        Element root = file.root;

        // Extract all the RentalEquipment elements as a list from the root element
        NodeList equipmentList = root.getElementsByTagName("Item");

        //Loop through NodeList and parse each necessary element 
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
                // else add a new key-value pair to the HashMap where the key is the equipment's type
                equipmentType = new ArrayList<Equipment>();
                equipment.put(type, equipmentType);
            }

            //Parses
            String name = element.getAttribute("type");
            String size = XMLFile.getTextContent(element, "size");
            int available = Integer.parseInt(XMLFile.getTextContent(element, "available"));

            Equipment newItem;

            // switch case on the type so it reads in any custome elemnts for that type.
            switch (type) {
                case "snowboard":
                case "ski":
                    RideType rideType = RideType.valueOf(XMLFile.getTextContent(element, "rideType").toUpperCase().replace(" ", "_"));
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
                    newItem = new Equipment(type, size, available);
                    break;
            }

            equipmentType.add(newItem);
        }
    }
    
    public HashMap<String, ArrayList<Equipment>> getEquipment() {
        return this.equipment;
    }

   // public static boolean save() {
        
    //}
}
