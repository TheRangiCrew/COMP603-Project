package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.Lifts.Lift;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sr95
 */
public class LiftsMenu {

    public static void liftMenu() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        // Loop until a valid response is given
        while (response == null) {
            System.out.println("\nLifts Menu ->\n"
                    + "1. Check lift status\n"
                    + "2. Set lift status\n"
                    + "R. Return to main menu");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    liftStatus();
                    break;
                case "2":
                    setStatus();
                    break;
                default:
                    System.out.println("Incorrect input, please try again.");
                    break;
            }

            response = null;
        }
    }

    /**
     * Prints a list of lifts and their statuses.
     */
    private static void liftStatus() {
        System.out.println("\n" + GlobalData.liftController.toString());
    }

    /**
     * Sets the status of chosen lift
     */
    private static void setStatus() {
        // Access the global array of lift objects
        ArrayList<Lift> lifts = GlobalData.liftController.getLifts();

        System.out.println("");
        
        // Loop through each lift printing their name and their index within the array
        for (int i = 0; i < lifts.size(); i++) {
            System.out.println(i+1 + ". " + lifts.get(i).toString());
        }

        Scanner scan = new Scanner(System.in);
        // The lift that is picked and will be updated
        Lift lift = null;

        // Loop until a valid response is given
        Integer response = null;
        while (response == null) {
            try {
                System.out.print("Enter the lift's number above to change the status: ");
                response = scan.nextInt();
                scan.reset();
                
                // Check if the response is within the bounds of the array else throw an exception
                if (response > lifts.size() || response < 1) {
                        throw new IndexOutOfBoundsException();
                    }
                
                // Set the selected lift to be updated
                lift = lifts.get(response - 1);
                
            } catch (InputMismatchException e) {
                System.out.println("Input was not an integer. Try again...");
                response = null;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Input was out of bounds. Try again...");
                response = null;
            }
        }
        
        System.out.println("");
        
        // Loop until a valid response is given
        response = null;
        while (response == null) {
            try {
                Lift.LiftStatus[] statuses = Lift.LiftStatus.values();
                                
                // Loop through the lift status enum and print the name and index
                for (int i = 0; i < statuses.length; i++) {
                    System.out.println((i + 1) + ". " + statuses[i].toString());
                }
                
                // Get the input
                System.out.println("Enter the status' number that you wish to set for " + lift.getName() + ":");
                response = scan.nextInt();
                scan.reset();
                
                // Check if the response was in bounds else throw an exception
                if (response > statuses.length || response < 1) {
                        throw new IndexOutOfBoundsException();
                    }
                       
                // Set the new status of the lift
                lift.setStatus(statuses[response - 1]);
            } catch (InputMismatchException e) {
                System.out.println("Input was not an integer. Try again...");
                response = null;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Input was out of bounds. Try again...");
                response = null;
            }
        }
        
        System.out.println("\n" + lift.getName() + " is now " + lift.getStatus().toString());
        
        return;
    }

}
