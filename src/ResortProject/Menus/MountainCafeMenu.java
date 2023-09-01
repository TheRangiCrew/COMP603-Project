package ResortProject.Menus;

import ResortProject.Cafe.Item;
import ResortProject.Cafe.Order;
import ResortProject.Data.GlobalData;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main Menu for the Mountain Cafe. All static methods for easy moving
 * between sections
 */
public class MountainCafeMenu {

    /**
     * If an order is created, it will be stored here. This will allow it to be
     * accessed through the various sub menus for ordering
     */
    private static Order order = null;

    /**
     * The main menu
     */
    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            // Options for the user
            System.out.println("\nMountain Cafe ->");
            System.out.println("----------------");
            System.out.println("Select an option below:");
            System.out.println("1. View Menu");
            System.out.println("2. Begin Order");
            System.out.println("R. Return to main menu");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");

            switch (response) {
                // Return to the program's Main Menu
                case "r":
                    return;
                // View Menu
                case "1":
                    System.out.println(GlobalData.cafe.toString());
                    break;
                // Begin Order
                case "2":
                    orderMenu();
                    break;
                // Handle all other input
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }

            // Loop until returned
            response = null;
        }
    }

    /**
     * The main menu to create an order and access various sub menus and functions
     */
    private static void orderMenu() {
        // Create new order
        order = new Order();

        // String representations of the different menu categories to reference later
        String[] categories = GlobalData.cafe.getMenu().keySet().toArray(new String[0]);

        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            // Options for user
            System.out.println("\n" + order.toString() + "\n");
            System.out.println("Mountain Cafe -> New Order");
            System.out.println("--------------------------");
            System.out.println("Select a sub-menu to select items from:");
            // Create a numbered list of the different categories in the menu so the user
            // can choose
            int index = 0;
            for (String category : categories) {
                System.out.println((index + 1) + ". " + category);
                index++;
            }
            // Fixed options
            System.out.println("E. Edit Order");
            System.out.println("F. Finish Order");
            System.out.println("C. Cancel Order");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                // Edit the order
                case "e":
                    // Do not allow editing if the order is empty
                    if (order.getNumOfItems() == 0) {
                        System.out.println("\nYour order is empty");
                        break;
                    }

                    edit();
                    break;
                // Finish the order
                case "f":
                    response = null;

                    // Do not allow if the order is empty
                    if (order.getNumOfItems() == 0) {
                        System.out.println("\nYour order is empty");
                        break;
                    }

                    // Print the order for the user to confirm
                    System.out.println("\n" + order.toString() + "\n");
                    System.out
                            .print("You order is above. If it is correct press Y, otherwise press N to go back (Y/N) ");
                    // Loop until valid response
                    while (response == null) {
                        // User input
                        response = scan.nextLine().toLowerCase();
                        scan.reset();

                        switch (response) {
                            // Yes
                            case "y":
                                // Try and submit the order using the currently logged in user
                                if (order.submit()) {
                                    // Will succeed if there is enough credit in their account
                                    System.out.println("\nYour order has been received! Thank you");
                                    // Save the program data
                                    GlobalData.save();
                                    // Exit the menu, back to the main menu
                                    return;
                                } else {
                                    // Will fail if there is not enough credit in their account
                                    System.out.println(
                                            "\nYou do not have enough credit in your account for this order.\nPlease top-up your credit before finishing the order.");
                                    System.out.println("\nPress any key to continue...");
                                    scan.nextLine();
                                    scan.reset();
                                    // Return to the ordering menu so the user may cancel the order
                                }
                                break;
                            // No
                            case "n":
                                // Return to the ordering menu since the user does not wish to continue
                                break;
                            // Handle all other input
                            default:
                                System.out.println("Invalid input. Please try again...");
                                response = null;
                                break;
                        }
                    }
                    break;
                // Cancel the order
                case "c":
                    response = null;
                    // Make sure the user actually wanted to cancel their order
                    System.out.print("Are you sure you want to cancel your order? (Y/N) ");
                    while (response == null) {
                        response = scan.nextLine().toLowerCase();
                        scan.reset();
                        switch (response) {
                            // Yes
                            case "y":
                                // Return to the ordering menu, cancelling the order
                                return;
                            // No
                            case "n":
                                // Loop back around to continue their order
                                break;
                            // Handle all other input
                            default:
                                System.out.println("Invalid input. Please try again...");
                                response = null;
                                break;
                        }
                    }
                    // Loop until valid input
                    response = null;
                    // All other input
                default:
                    try {
                        // Try and convert the user's response into a valid category
                        int option = Integer.parseInt(response) - 1;
                        // If the selected option was out-of-bounds of the array, throw an Exception
                        if (option < 0 || option > categories.length - 1) {
                            throw new Exception();
                        }

                        // Get the selected category and move to the ordering sub menu to select items
                        ArrayList<Item> selectedSubMenu = GlobalData.cafe.getMenu().get(categories[option]);

                        // Ordering sub meny
                        MountainCafeMenu.subMenu(categories[option], selectedSubMenu);
                        response = null;

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please try again...");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again...");
                    }
            }

            // Loop until returned
            response = null;
        }
    }

    /**
     * A menu to control editing the current order
     */
    private static void edit() {
        // A string representation of the order's items to be referenced later
        String[] items = order.getItems().keySet().toArray(new String[0]);

        Scanner scan = new Scanner(System.in);
        String response = null;

        // Loop until valid input
        while (response == null) {
            // If the user tries to edit with an empty order, go back
            if (order.getNumOfItems() == 0) {
                System.out.println("Order is empty. Going back to the main menu");
                return;
            }

            // Print a numbered list of the items in the order
            System.out.println("\n" + order.toListedString() + "\n");
            System.out.print("Select an item from above by typing its corresponding number or 'R' to go back: ");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();

            // If the user chooses 'R', return to the main ordering meny
            if (response.equals("r")) {
                return;
            }

            try {
                // Try and convert the users input to a valid item
                int option = Integer.parseInt(response) - 1;

                // If the option is out of bounds of the list, try again...
                if (option < 0 || option > items.length - 1) {
                    throw new NumberFormatException();
                }

                // Get all items in the order with the chosen option name
                ArrayList<Item> itemList = order.getItems().get(items[option]);

                // Reset the response
                response = null;
                // Loop until valid response
                while (response == null) {

                    System.out.println("Are you sure you want to remove " + items[option] + "? (Y/N)");
                    // User input
                    response = scan.nextLine().toLowerCase();
                    scan.reset();

                    switch (response) {
                        // Yes
                        case "y":
                            // If there are more than one instance of the selected item...
                            if (itemList.size() > 1) {
                                // Ask the user how many they wish to remove
                                int num = -1;
                                while (num == -1) {
                                    System.out.println("This item was added " + itemList.size()
                                            + " times.\nHow many do you wish to remove? (0-" + itemList.size() + ")");
                                    try {
                                        // User input
                                        num = scan.nextInt();
                                        scan.reset();

                                        // If the input was out of bounds, try again...
                                        if (num < 0 || num > itemList.size()) {
                                            throw new InputMismatchException();
                                        }

                                        // If the input is 0, just loop back
                                        if (num == 0) {
                                            System.out.println("0 items removed");
                                            break;
                                        }

                                        /*
                                         * If the input is the same as the total number of selected items...
                                         * ...remove all instances of that item
                                         */
                                        if (num == itemList.size()) {
                                            order.remove(items[option]);
                                            System.out
                                                    .println("All orders for " + items[option] + " have been removed");
                                            break;
                                        }

                                        // If none of the above are satisfied, remove the provided number of the
                                        // selected item
                                        order.remove(items[option], num);

                                        System.out.println(num + (num == 1 ? " order" : " orders") + " for "
                                                + items[option] + " were removed from the order");

                                        // Handle any errors that occurred during the input process
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please try again...\n");
                                        num = -1;
                                        scan.next();
                                    }
                                }
                                // ...else remove all instances of the selected item
                            } else {
                                order.remove(items[option]);
                                System.out.println(items[option] + " was removed from the order");
                            }
                            break;
                        // No
                        case "n":
                            // Loop back around to continue editing
                            break;
                        // Handle all other input
                        default:
                            System.out.println("Invalid input. Please try again...");
                            response = null;
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }

            // Loop until returned
            response = null;
        }

    }

    /**
     * Sub menu to provide users with a way to select items from the selected
     * cateogry in the ordering meny
     * 
     * @param category the cateogry selected
     * @param items    the items from the category
     */
    private static void subMenu(String category, ArrayList<Item> items) {
        Scanner scan = new Scanner(System.in);
        String response = null;

        // Loop until valid response
        while (response == null) {
            System.out.println(category);
            System.out.println("--------------------");
            // Create a numbered list of the possible items to select from
            int index = 0;
            for (Item item : items) {
                System.out.println((index + 1) + ". " + item.toString());
                index++;
            }
            System.out.print("Select an item from above by typing its corresponding number or 'R' to go back: ");
            // User input
            response = scan.nextLine().toLowerCase();
            scan.reset();

            // If input is 'R', go back to the ordering menu
            if (response.equals("r")) {
                return;
            }

            try {
                // Try and parse the input as a valid option
                int option = Integer.parseInt(response) - 1;

                // If the option is out of bounds of the items, try again...
                if (option < 0 || option > items.size() - 1) {
                    throw new NumberFormatException();
                }

                // Find the selected item
                Item selectedItem = items.get(option);

                // Ask for the number of items to add
                int num = -1;
                while (num == -1) {
                    System.out.print("How many " + selectedItem.getName() + ", for " + selectedItem.getPriceString()
                            + ", do you wish to add? (0-10) ");
                    try {
                        // User input
                        num = scan.nextInt();
                        scan.reset();

                        // Hard coded min and max order of 10 to prevent over ordering
                        if (num < 0 || num > 10) {
                            throw new InputMismatchException();
                        }

                        // Add the provided number of items to the order
                        for (int i = 0; i < num; i++) {
                            order.add(selectedItem);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please try again...");
                        num = -1;
                        scan.next();
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
        }
    }

}
