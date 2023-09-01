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

    public static LiftController liftController;
    public static PeopleController peopleController;
    public static Cafe cafe;
    public static EquipmentController equipmentController;
    private static Person loggedInPerson = null;

    /**
     * Initialise all data in the program including reading XML data using the
     * respective classes
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

    public static Person getLoggedIn() {
        return loggedInPerson;
    }

    public static void setLoggedIn(Person person) {
        loggedInPerson = person;
    }

    /**
     * Saves the program's data and removes the current person as being logged in
     */
    public static void logout() {
        GlobalData.save();
        loggedInPerson = null;
    }

    public static void save() {
        liftController.save();
        peopleController.save();
    }

    /**
     * Handles the termination of data controllers and program processes
     * 
     * @return true if controllers and processes terminated successfully, else false
     */
    public static boolean close() {
        // Write lift data to disk and close data streams
        liftController.close();
        peopleController.close();

        return true;
    }

}
