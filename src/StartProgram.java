

import java.util.Scanner;
import java.util.List;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static ListItemHelper lih = new ListItemHelper();

    public static void addAVehicle(String make, String model, String color, String customModifications) {

        ListItem toAdd = new ListItem(make, model, color, customModifications);
        lih.insertItem(toAdd);
    }

    static void deleteAVehicle() {
        System.out.print("Enter the ID of the vehicle to delete: ");
        int idToDelete = in.nextInt();
        in.nextLine();

        ListItem toDelete = lih.searchForItemById(idToDelete);
        if (toDelete != null) {
            lih.deleteItem(toDelete);
            System.out.println("Vehicle deleted: " + toDelete.returnItemDetails());
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private static void editAVehicle() {
        System.out.println("How would you like to search? ");
        System.out.println("1 : Search by Make");
        System.out.println("2 : Search by Model");
        System.out.println("3 : Search by Color");
        System.out.println("4 : Search by Custom Modifications");
        int searchBy = in.nextInt();
        in.nextLine();

        List<ListItem> foundItems;

        switch (searchBy) {
            case 1:
                System.out.print("Enter the Make: ");
                String make = in.nextLine();
                foundItems = lih.searchForItemByMake(make);
                break;
            case 2:
                System.out.print("Enter the Model: ");
                String model = in.nextLine();
                foundItems = lih.searchForItemByModel(model);
                break;
            case 3:
                System.out.print("Enter the Color: ");
                String color = in.nextLine();
                foundItems = lih.searchForItemByColor(color);
                break;
            case 4:
                System.out.print("Enter Custom Modifications: ");
                String customModifications = in.nextLine();
                foundItems = lih.searchForItemByCustomModifications(customModifications);
                break;
            default:
                foundItems = null;
                break;
        }

        if (foundItems != null && !foundItems.isEmpty()) {
            System.out.println("Found Results.");
            for (ListItem l : foundItems) {
                System.out.println(l.getId() + " : " + l.returnItemDetails());
            }
            System.out.print("Which ID to edit: ");
            int idToEdit = in.nextInt();
            in.nextLine();

            ListItem toEdit = lih.searchForItemById(idToEdit);
            if (toEdit != null) {
                System.out.println("Retrieved " + toEdit.returnItemDetails());
                System.out.println("1 : Update Make");
                System.out.println("2 : Update Model");
                System.out.println("3 : Update Color");
                System.out.println("4 : Update Custom Modifications");
                int update = in.nextInt();
                in.nextLine();

                switch (update) {
                    case 1:
                        System.out.print("New Make: ");
                        String newMake = in.nextLine();
                        toEdit.setMake(newMake);
                        break;
                    case 2:
                        System.out.print("New Model: ");
                        String newModel = in.nextLine();
                        toEdit.setModel(newModel);
                        break;
                    case 3:
                        System.out.print("New Color: ");
                        String newColor = in.nextLine();
                        toEdit.setColor(newColor);
                        break;
                    case 4:
                        System.out.print("New Custom Modifications: ");
                        String newCustomModifications = in.nextLine();
                        toEdit.setCustomModifications(newCustomModifications);
                        break;
                    default:
                        break;
                }

                lih.updateItem(toEdit);
            } else {
                System.out.println("Vehicle not found.");
            }
        } else {
            System.out.println("No results found.");
        }
    }


    private static void viewAllCars() {
        List<ListItem> allItems = lih.showAllCars(); // Updated method name

        for (ListItem car : allItems) {
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Color: " + car.getColor());
            System.out.println("Custom Modifications: " + car.getCustomModifications());

            System.out.println();
        }
    }

}

