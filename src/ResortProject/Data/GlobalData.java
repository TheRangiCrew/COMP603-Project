package ResortProject.Data;

import ResortProject.Lifts.LiftController;

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
    
    /**
     * Lift data controller
     * @see LiftController
     */
    public static LiftController liftController;
    
    /**
     * Initialise all data in the program including reading XML data using the
     * respective classes
     */
    private GlobalData() {
        this.liftController = new LiftController();
    }
    
    /**
     * Provides access to the single instance of the Global Data
     * @return GlobalData instance
     */
    public static GlobalData getInstance() {
        return instance;
    }
    
    /**
     * Handles the termination of data controllers and program processes
     * @return true if controllers and processes terminated successfully, else false
     */
    public static boolean close() {
        // Write lift data to disk and close data streams
        liftController.close();
        
        return true;
    }
    
}
