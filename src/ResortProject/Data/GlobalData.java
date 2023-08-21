package ResortProject.Data;

import ResortProject.Lifts.LiftController;
import ResortProject.People.PeopleController;
import ResortProject.People.Person;

/**
 * Controls for all the data and state of the program using the Singleton Pattern
 * design principle.
 * 
 */
public class GlobalData {
    /**
     * Constructor creates only one instance for the whole program privately. Can be accessed globally
     */
    private static GlobalData instance = new GlobalData();
    
    public static LiftController liftController;
    public static PeopleController peopleController;
    private static Person loggedInPerson = null;
    
    /**
     * Initialise all data in the program including reading XML data using the
     * respective classes
     */
    private GlobalData() {
        this.liftController = new LiftController();
        this.peopleController = new PeopleController();
    }
    
    /**
     * Provides access to the single instance of the Global Data
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
    
    public static void logout() {
        loggedInPerson = null;
    }
    
    /**
     * Handles the termination of data controllers and program processes
     * @return true if controllers and processes terminated successfully, else false
     */
    public static boolean close() {
        // Write lift data to disk and close data streams
        liftController.close();
        peopleController.close();
        
        return true;
    }
    
}
