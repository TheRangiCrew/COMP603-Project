package ResortProject;

import ResortProject.Menus.Menu;
import ResortProject.Data.GlobalData;
import ResortProject.People.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ResortHub {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        while (quit != true) {
            System.out.println("+-----------------------------+");
            System.out.println("| WELCOME TO THE SNOW RESORT! |");
            System.out.println("+-----------------------------+\n");

            String response = null;

            while (response == null) {
                try {
                    System.out.println("L. Login");
                    System.out.println("C. Create Account");
                    System.out.println("Q. Quit");
                    System.out.print("Please select an option from above by typing one of the characters: ");

                    response = scan.nextLine().toLowerCase();

                    switch (response) {
                        case "l":
                            login();
                            break;
                        case "c":
                            signup();
                            System.out.println("");
                            break;
                        case "q":
                            GlobalData.save();
                            return;
                        default:
                            throw new InputMismatchException();
                    }

                    GlobalData.save();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again...\n");
                }
                
                response = null;
            }

        }
    }

    private static void login() {
        Scanner scan = new Scanner(System.in);
        LocalDate dob;
        String response = null;

        while (response == null) {
            while (GlobalData.getLoggedIn() == null) {
                try {
                    System.out.println("\nPlease enter the requested details to login");
                    System.out.print("Email: ");
                    response = scan.nextLine().toLowerCase();
                    scan.reset();
                    System.out.print("Birth date (DD-MM-YYYY): ");
                    dob = LocalDate.parse(scan.nextLine().trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    scan.reset();
                    // uses getPerson method to search the ArrayList of people for login details. returns a person if there is a match or null when no match.
                    GlobalData.setLoggedIn(GlobalData.peopleController.getPerson(response, dob));
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
            Menu.main();
        }
    }

    private static void signup() {
        Scanner scan = new Scanner(System.in);
        
        String firstName = null;
        String lastName = null;
        String dobString = null;
        LocalDate dob = null;
        String email = null;
        String phone = null;
        
        String exit = "exit";
        String nameRegex = "^[A-Za-z\\-\\.]+$";
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String phoneRegex = "^\\+?\\d+$";
        
        System.out.println("\nPlease provide the information specified by the prompts to complete the sign-up process or type 'Exit' at any time to cancel.\n");
        
        while (firstName == null) {
            System.out.print("First Name: ");
            firstName = scan.nextLine().trim();
            scan.reset();
            
            if (firstName.isEmpty()) {
                System.out.println("Your name is required. Please try again...\n");
                firstName = null;
            } else if (firstName.equalsIgnoreCase(exit)) {
                return;
            } else if (!(firstName.matches(nameRegex))) {
                System.out.println("Your name can only contain letters, hyphens (-) and periods (.). Please try again...\n");
                firstName = null;
            }
        }
        
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
                System.out.println("Your name can only contain letters, hyphens (-) and periods (.). Please try again...\n");
                lastName = null;
            }
        }
        
        while (dobString == null && dob == null) {
            System.out.print("Date of Birth (DD-MM-YYYY): ");
            dobString = scan.nextLine().trim();
            scan.reset();
            
            if (dobString.equalsIgnoreCase(exit)) {
                return;
            } 
            
            try {
                dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("The date entered was invalid (should be like 31-02-1997). Please try again...\n");
                dobString = null;
            }
        }
        
        while (email == null) {
            System.out.print("Email: ");
            email = scan.nextLine().trim();
            scan.reset();
            
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
        
        while (phone == null) {
            System.out.print("Phone: ");
            phone = scan.nextLine().trim();
            scan.reset();
            
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
        
        Person person = GlobalData.peopleController.addPerson(new Person(firstName, lastName, dob, email, phone));
        
        System.out.println("\nYour account has been created " + person.getFirstName() + "!\nYou may use it straight away by going back to the main menu and logging in."
                + "\nNOTE: Your account has no credit or lift passes added automatically. You may do this once logged in.");
        
        System.out.println("\nPress any key to continue...");
        scan.nextLine();
        
        return;
    }
}
