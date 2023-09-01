package ResortProject;

import ResortProject.Menus.Menu;
import ResortProject.Data.GlobalData;
import ResortProject.People.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The ResortHub includes the main for our program along with the sign in and
 * login methods.
 */
public class ResortHub {

    // Main method runs the home page to the UI and takes a user input to navigate
    // to its next menus.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        // While the user has not pressed q for quit keep running the program.
        while (quit != true) {
            System.out.println("+-----------------------------+");
            System.out.println("| WELCOME TO THE SNOW RESORT! |");
            System.out.println("+-----------------------------+\n");

            String response = null;

            // While the users response is null loop through to ahow the menu and allow user
            // to input.
            while (response == null) {
                try {
                    System.out.println("L. Login");
                    System.out.println("C. Create Account");
                    System.out.println("Q. Quit");
                    System.out.print("Please select an option from above by typing one of the characters: ");

                    response = scan.nextLine().toLowerCase();

                    // Swtich case is used to take the user to their desired menu or throw
                    switch (response) {
                        case "l":
                            login();
                            System.out.println("");
                            break;
                        case "c":
                            signup();
                            System.out.println("");
                            break;
                        case "q":
                            GlobalData.save();
                            return;
                        default:
                    }

                    // Save program data
                    GlobalData.save();

                // InputMismatchException and make user try again.
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again...\n");
                }

                response = null;
            }

        }
    }

    // Method to login menu
    private static void login() {
        Scanner scan = new Scanner(System.in);
        LocalDate dob;
        String response = null;

        // While user input and loggedIn is null cycles through the UI
        while (response == null) {
            while (GlobalData.getLoggedIn() == null) {
                // Attempts to try take user input is in correct format.
                try {
                    System.out.println("\nPlease enter the requested details to login or enter 'R' to cancel");
                    System.out.print("Email: ");
                    response = scan.nextLine().toLowerCase();
                    scan.reset();
                    if (response.equalsIgnoreCase("r") || response.isBlank()) {
                        return;
                    }
                    System.out.print("Birth date (DD-MM-YYYY): ");
                    String dobResponse = scan.nextLine().trim();
                    scan.reset();
                    if (dobResponse.equalsIgnoreCase("r")) {
                        return;
                    }
                    // Sets format for dob 
                    dob = LocalDate.parse(dobResponse, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    // uses getPerson method to search the ArrayList of people for login details.
                    // returns a person if there is a match or null when no match.
                    GlobalData.setLoggedIn(GlobalData.peopleController.getPerson(response, dob));
                    if (GlobalData.getLoggedIn() == null) {
                        System.out.println("Incorrect login details, please try again.");
                        response = null;
                    }
                // Catches exception and sets input back to null to continue while loop
                } catch (DateTimeParseException e) {
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                }
            }
            System.out.println("");
            Menu.main();
        }
    }
    // Signup collects the users information and adds a Person object to the global data
    private static void signup() {
        Scanner scan = new Scanner(System.in);

        String firstName = null;
        String lastName = null;
        String dobString = null;
        LocalDate dob = null;
        String email = null;
        String phone = null;

        // Regular Expressions to test names, emails, and phone numbers against 
        String exit = "exit";
        String nameRegex = "^[A-Za-z\\-\\.]+$";
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String phoneRegex = "^\\+?\\d+$";

        System.out.println(
                "\nPlease provide the information specified by the prompts to complete the sign-up process or type 'Exit' at any time to cancel.\n");
        // While first name is null loop through the UI
        while (firstName == null) {
            System.out.print("First Name: ");
            firstName = scan.nextLine().trim();
            scan.reset();
            
            // If firstName is empty asks user to try again
            if (firstName.isEmpty()) {
                System.out.println("Your name is required. Please try again...\n");
                firstName = null;
            } else if (firstName.equalsIgnoreCase(exit)) {
                return;
            } else if (!(firstName.matches(nameRegex))) {
                System.out.println(
                        "Your name can only contain letters, hyphens (-) and periods (.). Please try again...\n");
                firstName = null;
            }
        }
        // While last name is null loop through the UI
        while (lastName == null) {
            System.out.print("Last Name: ");
            lastName = scan.nextLine().trim();
            scan.reset();

            if (lastName.isEmpty()) {
                System.out.println("Your name is required. Please try again...\n");
                lastName = null;
            } else if (lastName.equalsIgnoreCase(exit)) {
                return;
            } else if (!(lastName.matches(nameRegex))) {
                System.out.println(
                        "Your name can only contain letters, hyphens (-) and periods (.). Please try again...\n");
                lastName = null;
            }
        }
        // while dobString and dob are null loop through the UI
        while (dobString == null && dob == null) {
            System.out.print("Date of Birth (DD-MM-YYYY): ");
            dobString = scan.nextLine().trim();
            scan.reset();
            // If dobString is equal to "exit", stop the signup process
            if (dobString.equalsIgnoreCase(exit)) {
                return;
            }
            
            // Tries to parse in dobString to a LocalDate format, if not catches and asks to try agian
            try {
                dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("The date entered was invalid (should be like 31-02-1997). Please try again...\n");
                dobString = null;
            }
        }
        
        // While email is null, loop through the UI 
        while (email == null) {
            System.out.print("Email: ");
            email = scan.nextLine().trim();
            scan.reset();
            
            // Makes sure the email is inputted correctly, if not asks user to try again
            if (email.isEmpty()) {
                System.out.println("Your email is required. Please try again...\n");
                email = null;
            } else if (email.equalsIgnoreCase(exit)) {
                return;
            } else if (!(email.matches(emailRegex))) {
                System.out.println("The email provided was not formatted correctly. Please try again...\n");
                email = null;
            }
        }
        
        // While phone is null, loop through the UI
        while (phone == null) {
            System.out.print("Phone: ");
            phone = scan.nextLine().trim();
            scan.reset();
            
            // Makes sure the phone number is inputted corectly, if not asks user to try again
            if (phone.isEmpty()) {
                System.out.println("Your phone number is required. Please try again...\n");
                phone = null;
            } else if (phone.equalsIgnoreCase(exit)) {
                return;
            } else if (!(phone.matches(phoneRegex))) {
                System.out.println("The phone number provided was not formatted correctly. Please try again...\n");
                phone = null;
            }
        }
        
        // Takes in all new variables and creates a Person object 
        Person person = GlobalData.peopleController.addPerson(new Person(firstName, lastName, dob, email, phone));
        
        // Tidy UI to show completion of sign up and after key press returns to main menu
        System.out.println("\nYour account has been created " + person.getFirstName()
                + "!\nYou may use it straight away by going back to the main menu and logging in."
                + "\nNOTE: Your account has no credit or lift passes added automatically. You may do this once logged in.");

        System.out.println("\nPress any key to continue...");
        scan.nextLine();

        return;
    }
}
