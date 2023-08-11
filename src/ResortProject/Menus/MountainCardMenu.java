package ResortProject.Menus;

import java.util.Scanner;

/**
 *
 * @author sr95
 */
public class MountainCardMenu {

    public static void mountainCard() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. New card holder.");
        System.out.println("2. Top up card.");
        System.out.println("3. View card details.");
        System.out.println("4. Buy lift pass.");
        System.out.println("R. Return to main menu.");

        String response = scan.nextLine().toLowerCase();
        scan.reset();

        switch (response) {
            case "r":
                return;
            case "1":
                MountainCardMenu.mountainCard();
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

    private static void buyLiftPass() {

    }

    private static void topUpCard() {

    }

    private static void viewCardDetails() {

    }

    private static void butLiftPass() {

    }
}
