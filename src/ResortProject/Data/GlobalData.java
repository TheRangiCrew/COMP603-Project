package ResortProject.Data;

import ResortProject.Cafe.Cafe;
import ResortProject.Lifts.LiftController;
import ResortProject.People.PeopleController;
import ResortProject.People.Person;
import ResortProject.RentalEquipment.EquipmentController;

/**
 * Controls for all the data and state of the program using the Singleton
 * Pattern
 * design principle.
 * 
 */
public class GlobalData {
    /**
     * Constructor creates only one instance for the whole program privately. Can be
     * accessed globally
     */
    private static GlobalData instance = new GlobalData();

    // Static variables for each Controller Class
    public static LiftController liftController;
    public static PeopleController peopleController;
    public static Cafe cafe;
    public static EquipmentController equipmentController;
    private static Person loggedInPerson = null;

    /**
     * Initialise all data in the program including reading XML data from file
     */
    private GlobalData() {
        GlobalData.equipmentController = new EquipmentController();
        GlobalData.peopleController = new PeopleController();
        GlobalData.cafe = new Cafe();
        GlobalData.liftController = new LiftController();
    }

    /**
     * Provides access to the single instance of the Global Data
     * 
     * @return GlobalData instance
     */
    public static GlobalData getInstance() {
        return instance;
    }

    /**
     * 
     * @return the currently logged in user
     * @see Person
     */
    public static Person getLoggedIn() {
        return loggedInPerson;
    }

    /**
     * Set the currently logged in person
     * 
     * @param person the person to log in
     * @see Person
     */
    public static void setLoggedIn(Person person) {
        loggedInPerson = person;
    }

    /**
     * Saves the program's data and resets the logged in person to null
     */
    public static void logout() {
        GlobalData.save();
        loggedInPerson = null;
    }

    /**
     * Save the programs data
     */
    public static void save() {
        liftController.save();
        peopleController.save();
    }
}
