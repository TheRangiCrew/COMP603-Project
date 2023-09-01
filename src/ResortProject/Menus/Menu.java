package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import java.util.Scanner;

public class Menu {

    public static void main() {
        Scanner scan = new Scanner(System.in);

        String response = null;
        while (response == null) {
            System.out.println("Please choose your desired location:");
            System.out.println("1. Credit & Lift Passes");
            System.out.println("2. Mountain Cafe");
            System.out.println("3. Rental Equipment");
            System.out.println("4. View Ski Lift Status");
            System.out.println("L. Log out");
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");
            switch (response) {
                case "1":
                    PersonMenu.main();
                    break;
                case "2":
                    MountainCafeMenu.main();
                    break;
                case "3":
                    RentalEquipmentMenu.main();
                    break;
                case "4":
                    System.out.println(GlobalData.liftController.toString());
                    break;
                case "l":
                    GlobalData.logout();
                    System.out.println("Good bye!");
                    return;

                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
            response = null;
        }
    }
}
