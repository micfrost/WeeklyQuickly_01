package main;

import java.util.Scanner;

public class SystemAccess {


    Scanner scanner = new Scanner(System.in);

    SystemOrder systemOrder = new SystemOrder();
    SystemInventory systemInventory = new SystemInventory();

    void accessUI() {
        System.out.println("- - - - - ");
        System.out.println("Shop Order System");
        String chosenOption;
        do {
            System.out.println("- - - - - ");
            System.out.println("Menu:");
            System.out.println("1. Access Inventory System.");
            System.out.println("2. Access Order System.");
            System.out.println("5. Exit");
            System.out.println("- - - - - ");
            System.out.print("Enter selected option: ");
            chosenOption = scanner.nextLine();
            switch (chosenOption) {
                case "1" -> openInventoryUI();
                case "2" -> openOrderUI();

                case "5" -> exit();
                default -> tryOneMoreTime();
            }

        } while (!chosenOption.equals("5"));
    }

    private void openInventoryUI() {
        systemInventory.inventoryUI();
    }

    private void openOrderUI() {
        systemOrder.orderUI();
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
