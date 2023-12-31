package main;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemOrder {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> productsList = SystemInventory.getProductsList();
    ArrayList<Item> itemsList = SystemInventory.getItemsList();

    void orderUI() {
        String chosenOption;
        do {
            System.out.println("- - - - - ");
            System.out.println("Shop Order System.");
            System.out.println("1. View all products in Offer.");
            System.out.println("2. Add to a cart.");
            System.out.println("3. Display the cart.");
            System.out.println("4. Pay the bill.");
            System.out.println("5. Exit");
            System.out.println("- - - - - ");
            System.out.print("Enter selected option: ");
            chosenOption = scanner.nextLine();
            switch (chosenOption) {
                case "1" -> viewProductsInOffer();
                case "2" -> addToCart();
                case "3" -> displayCart();
                case "4" -> payTheBill();
                case "5" -> exit();
                default -> tryOneMoreTime();
            }
        } while (!chosenOption.equals("5"));
    }

    private void viewProductsInOffer() {
        System.out.println("- - - - - ");
        System.out.println("Products in offer");


        for (Product product : productsList) {
            product.setProductQuantityInventory(0);
            for (Item item : itemsList) {
                if (item.getProduct() == product) {
                    product.setProductQuantityInventoryAdd(item.getItemQuantity());
                }
            }
            System.out.printf(product.displayProductInOffer());
        }
        System.out.println();
    }

    private void addToCart() {
        System.out.println("- - - - - ");
        boolean isInInventory = false;
        System.out.println("Enter an ID number of a product you want to add to a card.");
        int productID = Integer.parseInt(scanner.nextLine());

        for (Product product : productsList
        ) {
            if (product.getProductID() == productID) {
                isInInventory = true;
                break;
            }
        }

        try {
            if (isInInventory) {

                System.out.println("How many items would you like to order?");
                try {
                    int orderQuantity = Integer.parseInt(scanner.nextLine());
                    for (Product product : productsList
                    ) {
                        if (product.getProductID() == productID) {
                            if (product.getProductQuantityInventory() > orderQuantity) {

                                product.setProductQuantityOrdered(orderQuantity);

                                for (Item item : itemsList) {
                                    if (item.getProduct() == product) {
                                        if (item.getItemQuantity() > orderQuantity) {
                                            item.setItemQuantity(item.getItemQuantity() - orderQuantity);
                                        } else {
                                            int partOrderQuantity = item.getItemQuantity();
                                            item.setItemQuantity(0);
                                            orderQuantity = orderQuantity - partOrderQuantity;
                                        }
                                    }
                                }

                                System.out.println("Items ordered successfully.");
                            } else {
                                System.out.println("There is not enough items in Stock. Please make the order one more time.");
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("- - -\nOh no: Invalid quantity input (e.g., non-integer input).\nPlace an order again.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new Exception("- - -\nOh no: Invalid menu item selection.\nPlace an order with a proper name.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculateBill() {
        System.out.println();
        double bill = 0;
        for (Product product : productsList) {
            bill = bill + product.getPriceRetail() * product.getProductQuantityOrdered();
        }
        return bill;
    }

    private void displayCart() {
        double bill = calculateBill();
        System.out.println("- - - - - ");
        for (Product product : productsList) {
            if (product.getProductQuantityOrdered() != 0) {
                System.out.print(product.getProductName() + " ");
                System.out.print(product.getPriceRetail() + "€");
                System.out.println(", Ordered: " + product.getProductQuantityOrdered() + " item(s).");
            }
        }
        System.out.println("Total bill: " + bill + "€.");
    }

    public void payTheBill() {
        double bill = calculateBill();
        System.out.println("Enter the amount of money to pay the bill");
        try {
            double mooneyToPayTheBill = Double.parseDouble(scanner.nextLine());
            System.out.println("Given: \t" + mooneyToPayTheBill + "€" + "\nBill: \t" + bill + "€" + "\n- - - - -" + "\nRest: \t" + (mooneyToPayTheBill - bill) + "€");
            System.out.println("Thank you for your purchase. Have a nice day.");

        } catch (NumberFormatException e) {
            System.out.println("- - -\nOh no: Invalid payment input (e.g., non-numeric input when paying the bill).\nTry to pay one more time.");
        }
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





