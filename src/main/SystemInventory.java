package main;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemInventory {

    Scanner scanner = new Scanner(System.in);

    private Storage storage1;
    static ArrayList<Product> productsList = new ArrayList<>();;


    public SystemInventory() {

        storage1 = new Storage("Storage001", "StorageWQ1", 10,"Leipzig");

        productsList.add(new Product("001", "Coffee", 3.5, 0,  0.1));
        productsList.add(new Product("002", "Icetea", 2.5,0,  0.1));
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    void inventoryUI() {
        String chosenOption;
        do {
            System.out.println("- - - - - ");
            System.out.println("Shop Inventory System");
            System.out.println("1. View products in the inventory. ");
            System.out.println("2. Add a new product to the inventory.");
            System.out.println("3. Add items of already existing product to the inventory.");
            System.out.println("4. Display Storage information.");
            System.out.println("5. Exit");
            System.out.println("- - - - - ");
            System.out.print("Enter selected option: ");
            chosenOption = scanner.nextLine();
            switch (chosenOption) {
                case "1" -> viewProductsInventory();
                case "2" -> addNewProductsInventory();
                case "3" -> addItemsExistingProduct();
                case "4" -> displayStorageInfo();
                case "5" -> exit();
                default -> tryOneMoreTime();
            }
        } while (!chosenOption.equals("5"));
    }


    private void viewProductsInventory() {
        System.out.println("- - - - - ");
        System.out.println("Products in the Inventory:");
        for (Product product : productsList
        ) {
            System.out.printf(product.displayProductInventory());
        }
        System.out.println();
    }

    private void addNewProductsInventory() {
        System.out.println("Enter a Product ID:");
        String productID = scanner.nextLine();
        System.out.println("Enter a Product Name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter a Price Retail: ");
        double priceRetail = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a Space Required to store a Product: ");
        double spaceRequired = Double.parseDouble(scanner.nextLine());
        productsList.add(new Product(productID, productName, priceRetail, 0,spaceRequired));
        System.out.println("Product added successfully.");
    }

    private void addItemsExistingProduct() {
        System.out.println("- - - - - ");
        boolean isInInventory = false;
        System.out.println("Enter an Product ID you want to add to the Inventory.");
        String productID = scanner.nextLine();

        for (Product product : productsList
        ) {
            if (product.getProductID().equals(productID)) {
                isInInventory = true;
                break;
            }
        }
        try {
            if (isInInventory) {
                System.out.println("How many items do you want to add to the Inventory?");
                try {
                    int AdditionalItemsQuantity = Integer.parseInt(scanner.nextLine());


                    for (Product product : productsList
                    ) {
                        if (product.getProductID().equals(productID)) {

                            boolean isEnoughStorageSpace = storage1.getStorageSpaceAvailable() -
                                    product.getSpaceRequired() * AdditionalItemsQuantity >= 0;

                            if(isEnoughStorageSpace){
                                product.setSpaceOccupiedAllItems(product.getSpaceRequired() * AdditionalItemsQuantity);
                                storage1.setStorageSpaceOccupied(product.getSpaceRequired() * AdditionalItemsQuantity);
                                product.setQuantityInventoryAdd(AdditionalItemsQuantity);
                                System.out.println("Items added successfully.");
                            }

                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("- - -\nOh no: Invalid quantity input (e.g., non-integer input).\nTry one more time.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new Exception("- - -\nOh no: Invalid product selection.\nTry one more time.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayStorageInfo() {
        System.out.println(storage1.displayStorage());
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
