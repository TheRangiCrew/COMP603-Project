package ResortProject.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sr95
 */
public class MountainCardMenu {

    public static void mountainCard() {
        Scanner scan = new Scanner(System.in);
        String response = null;
        System.out.println("1. New card holder.");
        System.out.println("2. Top up card.");
        System.out.println("3. View card details.");
        System.out.println("4. Buy lift pass.");
        System.out.println("R. Return to main menu.");

        while (response == null) {
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    MountainCardMenu.newCardHolder();
                    break;
                case "2":
                    MountainCardMenu.topUpCard();
                    break;
                case "3":
                    MountainCardMenu.viewCardDetails();
                    break;
                case "4":
                    MountainCardMenu.buyLiftPass();
                    break;
                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
        }
    }
    // needs birthDate to be checked for correct input. details to be saved to data file.
    private static void newCardHolder() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your details below.");
        System.out.println("First name:");
        String firstName = scan.nextLine();
        System.out.println("Last name:");
        String lastName = scan.nextLine();
        System.out.println("Birth date in the form dd-mm-yyyy:");
        String birthDate = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine().toLowerCase();
        System.out.println("Phone number:");
        String phone = scan.nextLine();
        System.out.println("Thanks, your card has been created.");
    }
    // class still needs a loop.
    private static void topUpCard() {
        Scanner scan = new Scanner(System.in);
        int response = 0;
        try{
        System.out.println("Please insert amount to top up, or press 0 to return to previous menu.");
        response = scan.nextInt();
        scan.reset();
        
        if(response == 0) {
            MountainCardMenu.mountainCard();
        }
        else if (response < 0) {
            System.out.println("Must be a positive number, please try again.");
        }
        else {
            System.out.println("$" + response + " has been added to your card.");
            // needs to add and update money to card.
        }    
        }catch(InputMismatchException e) {
            System.out.println("Incorrect input, please try again.");
        }
    }
    //class needs a compare to and code if else statement.
    private static void viewCardDetails() {
        Scanner scan = new Scanner(System.in);
        String response = null;
        
        System.out.println("Please enter your E-mail address, or \"r\" to return to last menu");
        response = scan.nextLine().toLowerCase();
        scan.reset();      
    }
    //switch case needs to be completed.
    private static void buyLiftPass() {
        Scanner scan = new Scanner(System.in);
        String response = null;
        
        System.out.println("Please pick the pass you would like to buy.");
        System.out.println("1. Learner pass. A one day pass for beginner slopes only.");
        System.out.println("2. Single day pass. Full mountain.");
        System.out.println("3. Five day pass. Full mountain.");
        System.out.println("4. Seven day pass. Full mountain.");
        System.out.println("5. Season Pass. Full mountain.");
        System.out.println("R. Return to previous menu.");
        
        while (response == null) {
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    MountainCardMenu.mountainCard();
                case "1":
                    // Checks card has no valid mountain pass, if no pass, adds the learner pass to card.
                    break;
                case "2":
                    // Checks card has no valid mountain pass, if no pass, adds the Single day pass to card.
                    break;
                case "3":
                    // Checks card has no valid mountain pass, if no pass, adds the Five day pass to card.
                    break;
                case "4":
                    // Checks card has no valid mountain pass, if no pass, adds the Seven day pass to card.
                    break;
                case "5":
                    // Checks card has no valid mountain pass, if no pass, adds the Season pass to card.
                default:
                    System.out.println("Incorrect input, please try again.");
                    response = null;
                    break;
            }
        }
    }
}