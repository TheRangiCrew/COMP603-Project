package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.People.LiftPass;
import ResortProject.People.Person;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The menu to edit personal details and purchase credit/lift passes
 */
public class PersonMenu {

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        // Loop until valid input
        while (response == null) {
            // Options for the user
            System.out.println("Credit & Lift Passes ->");
            System.out.println("-----------------------");
            System.out.println("Select an option below:");
            System.out.println("1. View Details");
            System.out.println("2. Top Up Card");
            System.out.println("3. Buy Lift Pass");
            System.out.println("R. Return to main menu");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                // R
                case "r":
                    // Return back to the program's main menu
                    return;
                // View Details
                case "1":
                    // A combination of the user's up-to-date information printed
                    System.out.println("\n" + GlobalData.getLoggedIn().toString());
                    System.out.println("--------------------");
                    System.out.println(GlobalData.getLoggedIn().getPasses().size() + " Lift "
                            + (GlobalData.getLoggedIn().getPasses().size() == 1 ? "Pass" : "Passes"));
                    System.out.println(GlobalData.getLoggedIn().getLatestLiftPass() != null
                            ? GlobalData.getLoggedIn().getLatestLiftPass().toString() + "\n"
                            : "");
                    break;
                // Top Up Card
                case "2":
                    PersonMenu.topUpCard();
                    break;
                // Buy Lift Pass
                case "3":
                    PersonMenu.buyLiftPass();
                    break;
                // Handle all other inputs
                default:
                    System.out.println("Incorrect input, please try again.");
                    break;
            }
            // Loop until returned
            response = null;
        }
    }

    /**
     * Menu to allow users to top-up their credit
     */
    private static void topUpCard() {
        Scanner scan = new Scanner(System.in);
        Float response = null;
        // Loop until valid reponse
        while (response == null) {
            try {
                // Ask user for amount to top up
                System.out.print("Please enter the amount to top up, or enter 0 to return to previous menu: ");
                // User input
                response = scan.nextFloat();

                // If the input is zero...
                if (response == 0.0f) {
                    // ...go back...
                    return;
                    // ...else if the input is negative...
                } else if (response < 0.0f) {
                    // ...loop back around...
                    System.out.println("Must be a positive number, please try again.");
                    response = null;
                    // ...else...
                } else {
                    // ...format the input into a valid dollar unit (2dp)
                    DecimalFormat decformat = new DecimalFormat("0.00");
                    // Get the current logged in user
                    Person person = GlobalData.getLoggedIn();
                    // Add the credit
                    person.addToCredit(response);
                    // Confirmation message
                    System.out.println("\n$" + decformat.format(response)
                            + " has been added to your card. Balance is now $" + person.getCreditAsString());
                }
                // Save the global data
                GlobalData.save();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, please try again.");
                response = null;
                scan.next();
            }
        }
        // exit menu...
        System.out.println("\n");
    }

    /**
     * Menu to allow users to purchase a lift pass
     */
    private static void buyLiftPass() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        // If the user already has a valid, curent lift pass, do not allow them to
        // purchase another. Go back
        if (GlobalData.getLoggedIn().getLatestLiftPass() != null) {
            if (GlobalData.getLoggedIn().getLatestLiftPass().isValid()) {
                System.out.println("It appears you already have a valid Lift Pass.\n\n"
                        + GlobalData.getLoggedIn().getLatestLiftPass()
                        + "\n\nUse the above Lift Pass until its expiry date, then purchase another pass.\n");
                return;
            }
        }

        // Loop until valid response
        while (response == null) {
            // Options for user
            System.out.println("Please pick the pass you would like to buy.");
            System.out.println("1. Learner pass. A one day pass for beginner slopes only.");
            System.out.println("2. Single day pass. Full mountain.");
            System.out.println("3. Five day pass. Full mountain.");
            System.out.println("4. Seven day pass. Full mountain.");
            System.out.println("5. Season Pass. Full mountain.");
            System.out.println("R. Return to previous menu.");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                // R
                case "r":
                    // Return to the main person menu
                    return;
                // 1/2
                case "1":
                case "2":
                    // Add a new lift pass that lasts from the start to the end of the current day
                    GlobalData.getLoggedIn()
                            .addLiftPass(new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(23, 59)));
                    break;
                // Five day pass
                case "3":
                    // Add a new lift pass that lasts from the start of today to the end of 5 days
                    // from now
                    GlobalData.getLoggedIn().addLiftPass(
                            new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(5).atTime(23, 59)));
                    break;
                // Seven day pass
                case "4":
                    // Add a new lift pass that lasts from the start of today to the end of 7 days
                    // from now
                    GlobalData.getLoggedIn().addLiftPass(
                            new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(7).atTime(23, 59)));
                    break;
                // Season pass
                case "5":
                    // Add a new lift pass that last from the start of today to the end of the day
                    // of the 8th of October (season end)
                    GlobalData.getLoggedIn().addLiftPass(
                            new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.parse("2023-10-08").atTime(23, 59)));
                    break;
                // Handle all other input
                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
        }
        // Confirmation message
        System.out.println("\nLift Pass Added\n" + GlobalData.getLoggedIn().getLatestLiftPass().toString() + "\n");
        // Save global data
        GlobalData.save();
    }
}
