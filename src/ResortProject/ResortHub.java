package ResortProject;

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

            System.out.println("Please choose your desired location.");
            System.out.println("1. Lift passes");
            System.out.println("2. Top up a mountain card");
            System.out.println("3. Mountain cafe");
            System.out.println("4. Rental equipment");
            System.out.println("5. New card holder");
            System.out.println("Q. Close the program");

            String response = null;
            while (quit != true) {
                while (response == null) {
                    response = scan.nextLine().toLowerCase();

                    switch (response) {
                        case "q":
                            quit = true;
                            break;
                        case "1":
                            quit = true;
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
                        case "5":
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
