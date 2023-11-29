package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopOrderSystem {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> offerList;

    ShopOrderSystem() {
        offerList = new ArrayList<>();
        offerList.add(new Product("Table", 100));
        offerList.add(new Product("Chair", 200));
        offerList.add(new Product("Lamp", 300));
        offerList.add(new Product("Window", 400));
        offerList.add(new Product("Mirror", 500));
    }

    void userInterface() {}
}
