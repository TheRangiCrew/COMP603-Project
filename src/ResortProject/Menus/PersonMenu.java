package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.People.LiftPass;
import ResortProject.People.Person;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonMenu {

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Credit & Lift Passes ->");
            System.out.println("-----------------------");
            System.out.println("Select an option below:");
            System.out.println("1. View Details");
            System.out.println("2. Top Up Card");
            System.out.println("3. Buy Lift Pass");
            System.out.println("R. Return to main menu");
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");

            switch (response) {
                case "r":
                    return;
                case "1":
                    System.out.println(GlobalData.getLoggedIn().toString());
                    System.out.println("--------------------");
                    System.out.println(GlobalData.getLoggedIn().getPasses().size() + " Lift " + (GlobalData.getLoggedIn().getPasses().size() == 1 ? "Pass" : "Passes"));
                    System.out.println(GlobalData.getLoggedIn().getLatestLiftPass() != null
                            ? GlobalData.getLoggedIn().getLatestLiftPass().toString() + "\n"
                            : "");
                    break;
                case "2":
                    PersonMenu.topUpCard();
                    break;
                case "3":
                    PersonMenu.buyLiftPass();
                    break;
                default:
                    System.out.println("Incorrect input, please try again.");
                    break;
            }
            response = null;
        }
    }

    // class still needs a loop.
    private static void topUpCard() {
        Scanner scan = new Scanner(System.in);
        Float response = null;
        while (response == null) {
            try {
                System.out.println("Please insert amount to top up, or enter 0 to return to previous menu.");
                response = scan.nextFloat();
                scan.reset();

                if (response == 0.0f) {
                    return;
                } else if (response < 0.0f) {
                    System.out.println("Must be a positive number, please try again.");
                    response = null;
                } else {
                    DecimalFormat decformat = new DecimalFormat("0.00");
                    Person person = GlobalData.getLoggedIn();
                    person.addToCredit(response);
                    System.out.println("$" + decformat.format(response) + " has been added to your card. Balance is now " + person.getCredit());
                }
                GlobalData.save();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, please try again.");
            }
        }
        System.out.println("");
    }

    //switch case needs to be completed.
    private static void buyLiftPass() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        if (GlobalData.getLoggedIn().getLatestLiftPass() != null) {
            if (GlobalData.getLoggedIn().getLatestLiftPass().isValid()) {
                System.out.println("It appears you already have a valid Lift Pass.\n\n"
                        + GlobalData.getLoggedIn().getLatestLiftPass()
                        + "\n\nUse the above Lift Pass until its expiry date, then purchase another pass.\n");
                return;
            }
        }

        while (response == null) {
            System.out.println("Please pick the pass you would like to buy.");
            System.out.println("1. Learner pass. A one day pass for beginner slopes only.");
            System.out.println("2. Single day pass. Full mountain.");
            System.out.println("3. Five day pass. Full mountain.");
            System.out.println("4. Seven day pass. Full mountain.");
            System.out.println("5. Season Pass. Full mountain.");
            System.out.println("R. Return to previous menu.");

            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                case "2":
                    GlobalData.getLoggedIn().addLiftPass(new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(23, 59)));
                    break;
                case "3":
                    GlobalData.getLoggedIn().addLiftPass(new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(5).atTime(23, 59)));
                    break;
                case "4":
                    GlobalData.getLoggedIn().addLiftPass(new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(7).atTime(23, 59)));
                    break;
                case "5":
                    GlobalData.getLoggedIn().addLiftPass(new LiftPass(LocalDate.now().atStartOfDay(), LocalDate.parse("2023-10-08").atTime(23, 59)));
                    break;
                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
        }
        
        System.out.println("\nLift Pass Added\n" + GlobalData.getLoggedIn().getLatestLiftPass().toString() + "\n");
        
        GlobalData.save();
    }
}
