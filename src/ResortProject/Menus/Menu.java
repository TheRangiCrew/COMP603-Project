package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import java.util.Scanner;

/**
 * The Main Menu after loggin in to the program
 */
public class Menu {

    public static void main() {
        Scanner scan = new Scanner(System.in);

        String response = null;
        // Loop until a valid response is given
        while (response == null) {
            // Options for the user
            System.out.println("Please choose your desired location:");
            System.out.println("1. Credit & Lift Passes");
            System.out.println("2. Mountain Cafe");
            System.out.println("3. Rental Equipment");
            System.out.println("4. View Ski Lift Status");
            System.out.println("L. Log out");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");

            // Match the requested menus
            switch (response) {
                // Credit and Lift Passes
                case "1":
                    PersonMenu.main();
                    break;
                // Mountain Cafe
                case "2":
                    MountainCafeMenu.main();
                    break;
                // Rental Equipment
                case "3":
                    RentalEquipmentMenu.main();
                    break;
                // Ski Lift Status
                case "4":
                    System.out.println(GlobalData.liftController.toString());
                    break;
                // Logout
                case "l":
                    GlobalData.logout();
                    System.out.println("Good bye!");
                    return;
                // Handle all other input
                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }

            // Continue the loop unless returned
            response = null;
        }
    }
}
