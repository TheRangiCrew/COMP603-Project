package ResortProject;

import ResortProject.Menus.Menu;
import ResortProject.Data.GlobalData;
import ResortProject.People.Person;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author sr95
 */
public class ResortHub {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        LocalDate dobLogin;
        while (quit != true) {
            System.out.println("+-----------------------------+");
            System.out.println("| WELCOME TO THE SNOW RESORT! |");
            System.out.println("+-----------------------------+\n");
            String response = null;

            while (response == null) {
                while (GlobalData.getLoggedIn() == null) {
                    try {
                        System.out.println("Please login.");
                        System.out.print("Email: ");
                        response = scan.nextLine().toLowerCase();
                        scan.reset();
                        System.out.print("Birth date (YYYY-MM-DD): ");
                        dobLogin = LocalDate.parse(scan.nextLine().trim());
                        scan.reset();
                        // uses getPerson method to search the ArrayList of people for login details. returns a person if there is a match or null when no match.
                        GlobalData.setLoggedIn(GlobalData.peopleController.getPerson(response, dobLogin));
                        if (GlobalData.getLoggedIn() == null) {
                            System.out.println("Incorrect login details, please try again.");
                            response = null;

                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect input, please try again.");
                        response = null;
                    }
                }
                System.out.println("");
                Menu.MenuCode option = Menu.mainMenu();
                switch (option) {
                    case LOGOUT:
                        GlobalData.logout();
                        break;
                    case QUIT:
                        if (GlobalData.close()) {
                            quit = true;
                        }
                        break;
                }
            }
        }
    }
}
