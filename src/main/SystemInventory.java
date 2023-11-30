package main;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemInventory {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productsList;

    public SystemInventory() {
        productsList = new ArrayList<>();
        productsList.add(new Product("001", "Coffee", 3.5));
        productsList.add(new Product("002", "Icetea", 2.5));
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    void inventoryUI() {
        System.out.println("- - - - - ");
        System.out.println("Shop Inventory System");
        String chosenOption;
        do {
            System.out.println("- - - - - ");
            System.out.println("Menu:");
            System.out.println("1. View products in the inventory.");
            System.out.println("2. Add a new product to the inventory.");
            System.out.println("3. Add items of already existing product to the inventory.");
            System.out.println("4. Exit");
            System.out.println("- - - - - ");
            System.out.print("Enter selected option: ");
            chosenOption = scanner.nextLine();
            switch (chosenOption) {
                case "1" -> viewProductsInventory();
                case "2" -> addNewProductsInventory();
                case "3" -> addItemsExistingProduct();

                case "4" -> exit();
                default -> tryOneMoreTime();
            }
        } while (!chosenOption.equals("4"));
    }


    private void viewProductsInventory() {
        System.out.println("- - - - - ");
        System.out.println("Products in the Inventory");
        for (Product product : productsList
        ) {
            System.out.printf(product.displayProductInventory());
        }
        System.out.println();
    }

    private void addNewProductsInventory() {
    }
    private void addItemsExistingProduct() {
    }

    private void exit() {
        System.out.println("- - - - - ");
        System.out.println("The program was closed successfully. Nice.");
    }

    private void tryOneMoreTime() {
        System.out.println("- - - - - ");
        System.out.println("Try one more time please.");
    }

}
