package ResortProject.Menus;

import ResortProject.Cafe.Item;
import ResortProject.Data.GlobalData;
import java.util.ArrayList;
import java.util.Scanner;

public class MountainCafeMenu {

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Mountain Cafe ->");
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
//                    
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
            response = null;
        }
    }

    private static void order() {
        String[] categories = (String[]) GlobalData.cafe.getMenu().keySet().toArray();

        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Mountain Cafe -> New Order");
            System.out.println("--------------------------");
            System.out.println("Select a sub-menu to select items from:");
            int index = 0;
            for (String category : categories) {
                System.out.println((index + 1) + ". " + category);
                index++;
            }
            System.out.println("C. Cancel Order");
            response = scan.nextLine().toLowerCase();
            scan.reset();
            System.out.println("");

            if (response.equals("c")) {
                response = null;
                System.out.print("Are you sure you want to cancel your order? (Y/N)");
                while (response == null) {
                    response = scan.nextLine().toLowerCase();
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
            }

            try {
                int option = Integer.parseInt(response);
                // If the selected option was out-of-bounds of the array, throw an Exception
                if (option <= 0 || option > categories.length) {
                    throw new Exception();
                }

                ArrayList<Item> selectedSubMenu = GlobalData.cafe.getMenu().get(categories[option]);
                
                MountainCafeMenu.subMenu(categories[option], selectedSubMenu);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again...");
            }

            response = null;
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

            if (response.equals("R")) {
                return;
            }
        }
    }

}
