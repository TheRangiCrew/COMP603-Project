package ResortProject;

import ResortProject.Menus.MountainCardMenu;
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
        while (quit != true) {
            System.out.println("+------------------------+");
            System.out.println("| WELCOME TO THE RESORT! |");
            System.out.println("+------------------------+\n");

            while (quit != true) {

                System.out.println("Please choose your desired location.");
                System.out.println("1. Mountain card");
                System.out.println("2. Mountain cafe");
                System.out.println("3. Rental equipment");
                System.out.println("4. Lifts");
                System.out.println("Q. Close the program");

                String response = null;
                while (response == null) {
                    response = scan.nextLine().toLowerCase();
                    scan.reset();
                    switch (response) {
                        case "q":
                            quit = true;
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
                            quit = true;
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
