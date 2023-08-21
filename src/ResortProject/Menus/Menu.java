package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.Menus.PersonMenu;
import java.util.Scanner;

public class Menu {

    public static enum MenuCode {
        LOGOUT,
        QUIT
    }

    public static MenuCode mainMenu() {
        Scanner scan = new Scanner(System.in);

        String response = null;
        while (response == null) {
            System.out.println("Please choose your desired location:");
            System.out.println("1. Credit & Lift Passes");
            System.out.println("2. Mountain Cafe");
            System.out.println("3. Rental Equipment");
            System.out.println("4. View Skit Lift Status");
            System.out.println("L. Log out");
            System.out.println("Q. Log out and close the program");
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");
            switch (response) {
                case "q":
                    return MenuCode.QUIT;
                case "1":
                    PersonMenu.mountainCard();
                    break;
                case "2":
                    // quit = true;
                    break;
                case "3":
                    // quit = true;
                    break;
                case "4":
                    System.out.println(GlobalData.liftController.toString());
                    break;
                case "l":
                    System.out.println("Good bye!");
                    return MenuCode.LOGOUT;

                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
            response = null;
        }
        return MenuCode.QUIT;
    }
}
