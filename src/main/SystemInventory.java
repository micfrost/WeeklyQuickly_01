package main;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemInventory {

    Scanner scanner = new Scanner(System.in);

    private Storage storage1;
    private static ArrayList<Product> productsList = new ArrayList<>();
    private static ArrayList<Item> itemsList = new ArrayList<>();

    public SystemInventory() {

        storage1 = new Storage("Storage001", "StorageWQ1", 10,"Leipzig");

        productsList.add(new Product(1, "Coffee", 3.5,  0.1));
        productsList.add(new Product(2, "Icetea", 2.5,  0.1));
    }

    public static ArrayList<Product> getProductsList() {
        return productsList;
    }

    public static ArrayList<Item> getItemsList() {
        return itemsList;
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
        for (Product product : productsList) {
            product.setProductQuantityInventory(0);
            for (Item item : itemsList) {
                if (item.getProduct() == product) {
                    product.setProductQuantityInventoryAdd(item.getItemQuantity());
                }
            }
            System.out.printf(product.displayProductInventory());
        }
        System.out.println();
    }

    private void addNewProductsInventory() {

        int productID = productsList.size()+1;
        System.out.println("Enter a Product Name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter a Price Retail: ");
        double priceRetail = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a Space Required to store a Product: ");
        double spaceRequired = Double.parseDouble(scanner.nextLine());
        productsList.add(new Product(productID, productName, priceRetail,spaceRequired));
        System.out.println("Product added successfully.");
    }

    private void addItemsExistingProduct() {
        System.out.println("- - - - - ");

        System.out.println("Enter an Product ID you want to add to the Inventory.");
        int productID = Integer.parseInt(scanner.nextLine());
        int itemID = itemsList.size()+1;
        System.out.println("How many items do you want to add to the Inventory?");
        int itemQuantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter an expiryDate?");
        String expiryDate = scanner.nextLine();
        boolean isValid = true;




        boolean isProductAlreadyInInventory = false;
        for (Product product : productsList
        ) {
            if (product.getProductID() == productID) {
                isProductAlreadyInInventory = true;
                break;
            }
        }

        try {
            if (isProductAlreadyInInventory) {

                try {
                    int AdditionalItemsQuantity = itemQuantity;
                    for (Product product : productsList
                    ) {
                        if (product.getProductID() == productID) {

                            boolean isEnoughStorageSpace = storage1.getStorageSpaceAvailable() -
                                    product.getSpaceRequiredOneItem() * AdditionalItemsQuantity >= 0;

                            if(isEnoughStorageSpace){
                                product.setSpaceOccupiedAdditionalItems(product.getSpaceRequiredOneItem() * AdditionalItemsQuantity);
                                storage1.setStorageSpaceOccupiedAdditionalItems(product.getSpaceRequiredOneItem() * AdditionalItemsQuantity);

                                itemsList.add(new Item(product,itemID,itemQuantity,isValid,expiryDate));
//                                product.setQuantityInventoryAdd(AdditionalItemsQuantity);

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
