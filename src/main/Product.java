package main;

public class Product {
    private String productID;
    private String productName;
    private String description;
    private double priceProducer;
    private double priceRetail;
    private int quantityInventory;
    private int quantityOrdered;
    private double spaceRequired;
    private double spaceOccupiedAllItems;


    public Product(String productID, String productName, double priceRetail, int quantityInventory, double spaceRequired) {
        this.productID = productID;
        this.productName = productName;
        this.priceRetail = priceRetail;
        this.quantityInventory = quantityInventory;
        this.spaceRequired = spaceRequired;
    }

    public Product(String productID, String productName, double priceProducer, double priceRetail, int quantityInventory, double spaceRequired) {
        this.productID = productID;
        this.productName = productName;
        this.priceProducer = priceProducer;
        this.priceRetail = priceRetail;
        this.quantityInventory = quantityInventory;
        this.spaceRequired = spaceRequired;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceProducer() {
        return priceProducer;
    }

    public void setPriceProducer(double priceProducer) {
        this.priceProducer = priceProducer;
    }

    public double getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(double priceRetail) {
        this.priceRetail = priceRetail;
    }

    public int getQuantityInventory() {
        return quantityInventory;
    }

    public void setQuantityInventoryAdd(int quantity) {
        this.quantityInventory = this.quantityInventory + quantity;
    }
    public void setQuantityInventorySub(int quantity) {
        this.quantityInventory = this.quantityInventory - quantity;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getSpaceRequired() {
        return spaceRequired;
    }

    public void setSpaceRequired(double spaceRequired) {
        this.spaceRequired = spaceRequired;
    }

    public double getSpaceOccupiedAllItems() {
        return spaceOccupiedAllItems;
    }

    public void setSpaceOccupiedAllItems(double addItemsSpace) {
        this.spaceOccupiedAllItems = this.spaceOccupiedAllItems+ addItemsSpace;
    }


    public String getAvailable() {
        if (quantityInventory > 0) {
            return "Ready to buy";
        } else {
            return "Sold out";
        }
    }

    public String displayProductOrder() {
        return "ID "+ productID +
                ", " + productName +
                ": " + String.format("%.2f", priceRetail) +
                ", " + getAvailable() +
                "\n";
    }

    public String displayProductInventory() {
        return "ID "+ productID +
                ", " + productName +
                ", quantity: " + getQuantityInventory()+
                ", Space Required for an item: " + String.format("%.2f m3", spaceRequired) +
                "\n";
    }

}


