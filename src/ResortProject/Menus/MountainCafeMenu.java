package ResortProject.Menus;

import ResortProject.Cafe.Item;
import ResortProject.Cafe.Order;
import ResortProject.Data.GlobalData;
import java.util.ArrayList;
import java.util.Scanner;

public class MountainCafeMenu {

    private static Order order = null;

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("\nMountain Cafe ->");
            System.out.println("----------------");
            System.out.println("Select an option below:");
            System.out.println("1. View Menu");
            System.out.println("2. Begin Order");
            System.out.println("R. Return to main menu");
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");

            switch (response) {
                case "r":
                    return;
                case "1":
                    System.out.println(GlobalData.cafe.toString());
                    break;
                case "2":
                    orderMenu();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
            response = null;
        }
    }

    private static void orderMenu() {
        order = new Order();

        String[] categories = GlobalData.cafe.getMenu().keySet().toArray(new String[0]);

        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("\n" + order.toString() + "\n");
            System.out.println("Mountain Cafe -> New Order");
            System.out.println("--------------------------");
            System.out.println("Select a sub-menu to select items from:");
            int index = 0;
            for (String category : categories) {
                System.out.println((index + 1) + ". " + category);
                index++;
            }
            System.out.println("E. Edit Order");
            System.out.println("F. Finish Order");
            System.out.println("C. Cancel Order");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "e":
                    edit();
                    break;
                case "f":
                    response = null;

                    if (order.getNumOfItems() == 0) {
                        System.out.println("\nYour order is empty");
                        break;
                    }

                    System.out.println("\n" + order.toString() + "\n");
                    System.out.print("You order is above. If it is correct press Y, otherwise press N to go back (Y/N) ");
                    while (response == null) {
                        response = scan.nextLine().toLowerCase();
                        scan.reset();
                        switch (response) {
                            case "y":
                                if (order.submit(GlobalData.getLoggedIn())) {
                                    System.out.println("\nYour order has been received! Thank you");
                                    return;
                                } else {
                                    System.out.println("\nYou do not have enough credit in your account for this order.\nPlease top-up your credit before finishing the order.");
                                    System.out.println("\nPress any key to continue...");
                                    scan.nextLine();
                                    scan.reset();
                                }
                                break;
                            case "n":
                                break;
                            default:
                                System.out.println("Invalid input. Please try again...");
                                response = null;
                                break;
                        }
                    }
                    break;
                case "c":
                    response = null;
                    System.out.print("Are you sure you want to cancel your order? (Y/N) ");
                    while (response == null) {
                        response = scan.nextLine().toLowerCase();
                        scan.reset();
                        switch (response) {
                            case "y":
                                return;
                            case "n":
                                break;
                            default:
                                System.out.println("Invalid input. Please try again...");
                                response = null;
                                break;
                        }
                    }
                    response = null;
                default:
                    try {
                    int option = Integer.parseInt(response) - 1;
                    // If the selected option was out-of-bounds of the array, throw an Exception
                    if (option < 0 || option > categories.length - 1) {
                        throw new Exception();
                    }

                    ArrayList<Item> selectedSubMenu = GlobalData.cafe.getMenu().get(categories[option]);

                    MountainCafeMenu.subMenu(categories[option], selectedSubMenu);
                    response = null;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please try again...");
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again...");
                }
            }

            response = null;
        }
    }

    private static void edit() {
        String[] items = order.getItems().keySet().toArray(new String[0]);
            
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println(order.toListedString() + "\n");
            System.out.print("Select an item from above by typing its corresponding number or 'R' to go back: ");

            response = scan.nextLine().toLowerCase();
            scan.reset();
            
            if (response.equals("r")) {
                return;
            }
            
            try {
                int option = Integer.parseInt(response)-1;
                
                if (option < 0 || option > items.length-1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
            }
        }

    }

    private static void subMenu(String category, ArrayList<Item> items) {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println(category);
            System.out.println("--------------------");
            int index = 0;
            for (Item item : items) {
                System.out.println((index + 1) + ". " + item.toString());
                index++;
            }
            System.out.print("Select an item from above by typing its corresponding number or 'R' to go back: ");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            if (response.equals("r")) {
                return;
            }

            try {

                int option = Integer.parseInt(response) - 1;

                response = null;

                if (option < 0 || option > items.size() - 1) {
                    throw new NumberFormatException();
                }

                Item selectedItem = items.get(option);

                System.out.println("Add " + selectedItem.getName() + " for " + selectedItem.getPriceString() + "? (Y/N)");
                while (response == null) {
                    response = scan.nextLine().toLowerCase();
                    scan.reset();

                    switch (response) {
                        case "y":
                            order.add(selectedItem);
                            return;
                        case "n":
                            break;
                        default:
                            System.out.println("Invalid input. Please try again...");
                            response = null;
                            break;
                    }

                }

                response = null;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
        }
    }

}
