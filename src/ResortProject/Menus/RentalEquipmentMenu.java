package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.RentalEquipment.Equipment;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentalEquipmentMenu {

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Rental Equipment ->");
            System.out.println("-------------------");
            System.out.println("Select an option below:");
            System.out.println("1. Snowboard rental");
            System.out.println("2. Ski rental");
            System.out.println("3. Taboggan rental");
            System.out.println("4. Boot rental");
            System.out.println("5. Clothing rental");
            System.out.println("R. Return to main menu");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    RentalEquipmentMenu.snowboardRental();
                    break;
                default:
                    return;
            }
        }
    }

    public static void snowboardRental() {
        ArrayList<Equipment> boardRental = GlobalData.equipmentController.getEquipment().get("snowboard");
        Collections.sort(boardRental);

        Scanner scan = new Scanner(System.in);
        String response = null;
        while (response == null) {
            System.out.println("Please choose snowboard length (available):");
            System.out.print("Size (cm) ");
            for (int i = 0; i < boardRental.size(); i++) {
                if (boardRental.get(i).isAvailable()) {
                    System.out.print("| " + boardRental.get(i).getSize() + " " + (i==boardRental.size()-1 ? "|" : ""));
                }
            }
            System.out.print("\n          ");
            for (int i = 0; i < boardRental.size(); i++) {
                if (boardRental.get(i).isAvailable()) {
                    System.out.print("|-----" + (i==boardRental.size()-1 ? "|" : ""));
                }
            }
            System.out.print("\nAvailable ");
            NumberFormat numFormat = new DecimalFormat("000");
            for (int i = 0; i < boardRental.size(); i++) {
                if (boardRental.get(i).isAvailable()) {
                    System.out.print("| " + numFormat.format(boardRental.get(i).getAvailable()) + " " + (i==boardRental.size()-1 ? "|" : ""));
                }
            }
            System.out.println("");
            response = scan.nextLine();
            
        }
    }
}
