package ResortProject.Menus;

import ResortProject.Data.GlobalData;
import ResortProject.RentalEquipment.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalEquipmentMenu {

    public static void main() {
        Scanner scan = new Scanner(System.in);
        String response = null;

        while (response == null) {
            System.out.println("Rental Equipment ->");
            System.out.println("-------------------");
            System.out.println("Select an option below:");
            System.out.println("1. Snowboard rental     $25");
            System.out.println("2. Ski rental           $25");
            System.out.println("3. Taboggan rental      $10");
            System.out.println("4. Boot rental          $25");
            System.out.println("5. Clothing rental      $10");
            System.out.println("R. Return to main menu");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    RentalEquipmentMenu.snowboardRental();
                    break;
                case "2":
                    RentalEquipmentMenu.skiRental();
                    break;
                case "3":
                    if (GlobalData.getLoggedIn().deductFromCredit(10)) {
                        System.out.println("\nEquipment hired! Thank you.");
                    } else {
                        System.out.println("\nNot enough credit, please top up your accout.");
                        System.out.println("Press any key to continue...");
                        scan.next();
                        scan.reset();
                    }
                    break;
                case "4":
                    RentalEquipmentMenu.bootRental();
                    break;
                case "5":
                    RentalEquipmentMenu.clothingRental();
                    break;
                default:
                    System.out.println("Invalid input. Please try again...");
                    response = null;
            }
        }
    }

    /**
     * A generic function for rental equipment to select the type of ski/board
     *
     * @return The RideType the user selects
     * @see RideType
     */
    private static RideType selectRide() {
        Scanner scan = new Scanner(System.in);
        // The ride type to be return
        RideType rideType = null;

        String response = null;

        while (response == null) {
            System.out.println("Please choose a ride style:");
            System.out.println("1. All Mountain");
            System.out.println("2. Freeride");
            System.out.println("3. Park");
            System.out.println("4. On Piste");
            System.out.println("R. Return to Rental Equipment Menu");
            response = scan.nextLine().toLowerCase();

            switch (response) {
                // If the user selects 'R', return since rideType is already null
                case "r":
                    response = null;
                    RentalEquipmentMenu.main();
                    break;
                case "1":
                    rideType = RideType.ALL_MOUNTAIN;
                    break;
                case "2":
                    rideType = RideType.FREERIDE;
                    break;
                case "3":
                    rideType = RideType.PARK;
                    break;
                case "4":
                    rideType = RideType.ON_PISTE;
                    break;
                default:
                    // Handle any unexpected output...
                    System.out.println("Invalid input. Please try again...");
                    rideType = null;
                    response = null;
                    break;
            }

        }

        // The ride type to be return
        return rideType;
    }

    private static void snowboardRental() {
        ArrayList<Snowboard> boardRental = GlobalData.equipmentController.getSnowboards();
        Collections.sort(boardRental);

        Scanner scan = new Scanner(System.in);
        String response = null;

        // Get the rideType
        RideType rideType = selectRide();

        // If the user chooses to go back to the RentalEquipmentMenu
        if (rideType == null) {
            return;
        }

        ArrayList<Snowboard> filteredBoards = new ArrayList<>();
        // Filter the snowboards by RideType
        for (Snowboard equipment : boardRental) {
            if (equipment.getRideType() == rideType) {
                filteredBoards.add(equipment);
            }
        }

        Snowboard snowboard = null;

        // Get the snowboard size
        while (response == null) {

            RentalEquipmentMenu.generateIntTable(filteredBoards);

            System.out.print("Please choose snowboard length (available) or r to return: ");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            // If statement to check for return 'r'
            if (response.equals("r")) {
                RentalEquipmentMenu.main();
                break;
            }

            int chosenSize;
            // Check for invalid input (input was not an integer) and throw an error
            try {
                chosenSize = Integer.parseInt(response);

                // Check if the size is a valid size
                for (Snowboard potential : filteredBoards) {
                    if (potential.getIntSize() == chosenSize) {
                        snowboard = potential;
                        break;
                    }
                }

                if (snowboard == null) {
                    System.out.println("Invalid size. Please try again...");
                    response = null;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
            catch (NumberFormatException ee) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
        }

        // Deduct credit from person. Handle if not enough credit
        if (GlobalData.getLoggedIn().deductFromCredit(25)) {
            System.out.println("\nEquipment hired! Thank you.");
        } else {
            System.out.println("\nNot enough credit, please top up your accout.");
            System.out.println("Press any key to continue...");
            scan.nextLine();
            scan.reset();

        }

        RentalEquipmentMenu.main();
    }

    private static void skiRental() {
        ArrayList<Skis> skiRental = GlobalData.equipmentController.getSkis();
        Collections.sort(skiRental);

        Scanner scan = new Scanner(System.in);
        String response = null;

        // Get the rideType
        RideType rideType = selectRide();

        // If the user chooses to go back to the RentalEquipmentMenu
        if (rideType == null) {
            return;
        }

        ArrayList<Skis> filteredSkis = new ArrayList<>();
        // Filter the skis by RideType
        for (Skis equipment : skiRental) {
            if (equipment.getRideType() == rideType) {
                filteredSkis.add(equipment);
            }
        }

        Skis skis = null;

        // Get the ski size
        while (response == null) {

            generateIntTable(filteredSkis);

            System.out.println("");
            System.out.print("Please choose ski length (available) or r to return: ");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            // If statement to check for return 'r'
            if (response.equalsIgnoreCase("r")) {
                return;
            }

            int chosenSize;
            // Check for invalid input (input was not an integer) and throw an error
            try {
                chosenSize = Integer.parseInt(response);

                // Check if the size is a valid size
                for (Skis potential : filteredSkis) {
                    if (potential.getIntSize() == chosenSize) {
                        skis = potential;
                        break;
                    }
                }

                if (skis == null) {
                    System.out.println("Invalid size. Please try again...");
                    response = null;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
            catch (NumberFormatException ee) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }
        }

        // Deduct credit from person. Handle if not enough credit
        if (GlobalData.getLoggedIn().deductFromCredit(25)) {
            System.out.println("\nEquipment hired! Thank you.");
        } else {
            System.out.println("\nNot enough credit, please top up your accout.");
            System.out.println("Press any key to continue...");
            scan.nextLine();
            scan.reset();

        }

        RentalEquipmentMenu.main();
    }

    private static void bootRental() {
        ArrayList<Boots> bootRental = GlobalData.equipmentController.getBoots();
        Collections.sort(bootRental);

        Scanner scan = new Scanner(System.in);
        String response = null;

        BootType type = null;

        while (response == null) {
            System.out.println("Please choose a boot type: ");
            System.out.println("1. Ski Boot");
            System.out.println("2. Snowboard Boot");
            System.out.println("R. Return to Rental Equipment Menu");
            response = scan.nextLine().toLowerCase();

            switch (response) {
                case "r":
                    return;
                case "1":
                    type = BootType.SKI;
                    break;
                case "2":
                    type = BootType.SNOWBOARD;
                    break;
                default:
                    System.out.println("Invalid input. Please try again...");
                    response = null;
                    break;
            }
        }

        response = null;
        Boots boots = null;

        ArrayList<Boots> filteredBoots = new ArrayList<>();
        // Filter the boots by bootType
        for (Boots equipment : bootRental) {
            if (equipment.getBootType() == type) {
                filteredBoots.add(equipment);
            }
        }

        while (response == null) {
            generateIntTable(bootRental);

            System.out.println("Please choose a shoe size or enter 'R' to cancel: ");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            // If statement to check for return 'r'
            if (response.equals("r")) {
                return;
            }

            int chosenSize;
            // Check for invalid input (input was not an integer) and throw an error
            try {
                chosenSize = Integer.parseInt(response);

                // Check if the size is a valid size
                for (Boots potential : filteredBoots) {
                    if (potential.getIntSize() == chosenSize) {
                        boots = potential;
                        break;
                    }
                }

                if (boots == null) {
                    System.out.println("Invalid size. Please try again...");
                    response = null;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again...");
                response = null;
            }

        }

        // Deduct credit from person. Handle if not enough credit
        if (GlobalData.getLoggedIn().deductFromCredit(25)) {
            System.out.println("\nEquipment hired! Thank you.");
        } else {
            System.out.println("\nNot enough credit, please top up your accout.");
            System.out.println("Press any key to continue...");
            scan.nextLine();
            scan.reset();
        }

        return;

    }

    private static void clothingRental() {

        ArrayList<Clothing> clothingRental = GlobalData.equipmentController.getClothing();
        Collections.sort(clothingRental);

        Scanner scan = new Scanner(System.in);
        String response = null;

        ClothingType type = null;

        while (response == null) {

            System.out.println("Please choose a clothing type: ");
            System.out.println("1. Jacket");
            System.out.println("2. Pants");
            System.out.println("3. Helmet");
            System.out.println("4. Childs one piece");
            System.out.println("R. Return to rental equipent");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    type = ClothingType.JACKET;
                    break;
                case "2":
                    type = ClothingType.PANTS;
                    break;
                case "3":
                    type = ClothingType.HELMET;
                    break;
                case "4":
                    type = ClothingType.CHILDSONEPIECE;
                    break;
                default:
                    System.out.println("Invalid input. Please try again...");
                    response = null;
                    break;
            }
        }

        response = null;

        Gender gender = null;

        while (response == null) {

            System.out.println("Please choose a gender: ");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("R. Cancel");
            response = scan.nextLine().toLowerCase();
            scan.reset();

            switch (response) {
                case "r":
                    return;
                case "1":
                    gender = Gender.MALE;
                    break;
                case "2":
                    gender = Gender.FEMALE;
                    break;
                default:
                    System.out.println("Invalid input. Please try again...");
                    response = null;
                    break;
            }

        }

        Clothing clothing = null;

        // Filter the clothing by clothingType
        for (Clothing equipment : clothingRental) {
            if (equipment.getClothingType() == type && equipment.getGender() == gender) {
                clothing = equipment;
                break;
            }
        }

        // Deduct credit from person. Handle if not enough credit
        if (GlobalData.getLoggedIn().deductFromCredit(10)) {
            System.out.println("\nEquipment hired! Thank you.");
        } else {
            System.out.println("\nNot enough credit, please top up your accout.");
            System.out.println("Press any key to continue...");
            scan.nextLine();
        }

        return;

    }

    private static void generateIntTable(ArrayList<? extends Equipment> equipment) {
        NumberFormat numFormat = new DecimalFormat("000");
        // Print a table of the available sizes from the filtered list of snowbords
        System.out.println("");
        // Print the sizes
        System.out.print("Size (cm) ");
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).isAvailable()) {
                System.out.print(
                        "| " + numFormat.format(Integer.parseInt(equipment.get(i).getSize())) + " " + (i == equipment.size() - 1 ? "|" : ""));
            }
        }
        // New row line
        System.out.print("\n          ");
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).isAvailable()) {
                System.out.print("|-----" + (i == equipment.size() - 1 ? "|" : ""));
            }
        }
        // Print the availability of each size
        System.out.print("\nAvailable ");
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).isAvailable()) {
                System.out.print("| " + numFormat.format(equipment.get(i).getAvailable()) + " "
                        + (i == equipment.size() - 1 ? "|" : ""));
            }
        }

        System.out.println("");
    }
}
