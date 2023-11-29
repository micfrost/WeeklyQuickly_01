package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopOrderSystem {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> offerList;

    ShopOrderSystem() {
        offerList = new ArrayList<>();
        offerList.add(new Product("Coffee", 7.5));
        offerList.add(new Product("Tee", 2.5));
        offerList.add(new Product("Fanta", 1.5));
        offerList.add(new Product("Water", 1.0));
        offerList.add(new Product("Sugar", 2.0));
    }

    void userInterface() {}
}
