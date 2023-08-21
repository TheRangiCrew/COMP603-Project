package ResortProject;

import ResortProject.Data.GlobalData;
import ResortProject.Menus.MountainCardMenu;
import ResortProject.Menus.LiftsMenu;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sr95
 */
public class ResortHub {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        String EmailLogin;
        LocalDate DOBLogin;
        while (quit != true) {
            System.out.println("+-----------------------------+");
            System.out.println("| WELCOME TO THE SNOW RESORT! |");
            System.out.println("+-----------------------------+\n");
            String response = null;
            while (response == null) {
                try {
                    System.out.println("Please login.");
                    System.out.println("Email: ");
                    response = scan.nextLine();
                    scan.reset();
                    System.out.println("Birth date (YYYY-MM-DD): ");
                    DOBLogin = LocalDate.parse(scan.nextLine().trim());
                    scan.reset();
                } catch (DateTimeParseException e) {
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                }
            }
            while (quit != true) {
                
                System.out.println("Please choose your desired location.");
                System.out.println("1. Mountain card");
                System.out.println("2. Mountain cafe");
                System.out.println("3. Rental equipment");
                System.out.println("4. View ski lift status");
                System.out.println("L. Log out");
                System.out.println("Q. Log out and close the program");
                
                response = null;
                while (response == null) {
                    response = scan.nextLine().toLowerCase();
                    scan.reset();
                    switch (response) {
                        case "q":
                            if (GlobalData.close()) {
                                quit = true;
                            }
                            break;
                        case "1":
                            MountainCardMenu.mountainCard();
                            break;
                        case "2":
                            quit = true;
                            break;
                        case "3":
                            quit = true;
                            break;
                        case "4":
                            LiftsMenu.liftMenu();
                            break;
                        case "L":
                            
                            break;
                        default:
                            System.out.println("Incorrect input, please try again.");
                            response = null;
                            break;
                    }
                }
            }
        }
    }
}
