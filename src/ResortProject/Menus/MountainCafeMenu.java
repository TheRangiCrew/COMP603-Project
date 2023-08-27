package ResortProject.Menus;

import ResortProject.Cafe.Item;
import ResortProject.Data.GlobalData;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

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
    
    public static void order() {
        Set<Entry<String, ArrayList<Item>>> cafeMenu = GlobalData.cafe.getMenu().entrySet();
        
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Mountain Cafe -> New Order");
            System.out.println("--------------------------");
            System.out.println("Select a sub-menu to select items from:");
            int index = 0;
            for (Entry<String, ArrayList<Item>> category: cafeMenu) {
                System.out.println(index + ". " + category.getKey());
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
            
            int option;
            
            try {
                option = Integer.parseInt(response);
                
                // If the selected option was out-of-bounds of the array, throw an Exception
                if (option <= 0 || option > cafeMenu.size()) {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again...");
            }

            
            
            response = null;
        }
    }
    
}
