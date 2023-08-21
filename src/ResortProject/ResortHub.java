package ResortProject;

import ResortProject.Menus.Menu;
import ResortProject.Data.GlobalData;
import ResortProject.Menus.MountainCardMenu;
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
        boolean loggedOut = true;
        LocalDate DOBLogin;
        while (quit != true) {
            System.out.println("+-----------------------------+");
            System.out.println("| WELCOME TO THE SNOW RESORT! |");
            System.out.println("+-----------------------------+\n");
            String response = null;

            while (response == null) {
                while (loggedOut == true) {
                    try {
                        System.out.println("Please login.");
                        System.out.println("Email: ");
                        response = scan.nextLine().toLowerCase();
                        scan.reset();
                        System.out.println("Birth date (YYYY-MM-DD): ");
                        DOBLogin = LocalDate.parse(scan.nextLine().trim());
                        scan.reset();
                        // uses getPerson method to search the ArrayList of people for login details. returns a person if there is a match or null when no match.
                        Person loggedIn = GlobalData.peopleController.getPerson(response, DOBLogin);
                        if (loggedIn == null) {
                            System.out.println("Incorrect login details, please try again.");
                            response = null;

                        } else {
                            loggedOut = false;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect input, please try again.");
                        response = null;
                    }
                }
                Menu.MenuCode option = Menu.mainMenu();
                switch(option) {
                    case LOGOUT:
                        loggedOut = true;
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
