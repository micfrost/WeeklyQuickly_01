package main;

public class Product {
    private int productID;
    private String productName;
    private String description;
    private double priceProducer;
    private double priceRetail;
    private int productQuantityInventory;
    private int productQuantityOrdered;
    private double spaceRequiredOneItem;
    private double spaceOccupiedAllItems;


    public Product(int productID, String productName, double priceRetail, double spaceRequiredOneItem) {
        this.productID = productID;
        this.productName = productName;
        this.priceRetail = priceRetail;
        this.productQuantityInventory = productQuantityInventory;
        this.spaceRequiredOneItem = spaceRequiredOneItem;
    }

    public Product(int productID, String productName, double priceProducer, double priceRetail, int productQuantityInventory, double spaceRequiredOneItem) {
        this.productID = productID;
        this.productName = productName;
        this.priceProducer = priceProducer;
        this.priceRetail = priceRetail;
        this.productQuantityInventory = productQuantityInventory;
        this.spaceRequiredOneItem = spaceRequiredOneItem;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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

    public int getProductQuantityInventory() {
        return productQuantityInventory;
    }

    public void setProductQuantityInventory(int productQuantityInventory) {
        this.productQuantityInventory = productQuantityInventory;
    }

    public void setProductQuantityInventoryAdd(int quantity) {
        this.productQuantityInventory = this.productQuantityInventory + quantity;
    }
    public void setQuantityInventorySub(int quantity) {
        this.productQuantityInventory = this.productQuantityInventory - quantity;
    }

    public int getProductQuantityOrdered() {
        return productQuantityOrdered;
    }

    public void setProductQuantityOrdered(int productQuantityOrdered) {
        this.productQuantityOrdered = productQuantityOrdered;
    }

    public double getSpaceRequiredOneItem() {
        return spaceRequiredOneItem;
    }

    public void setSpaceRequiredOneItem(double spaceRequiredOneItem) {
        this.spaceRequiredOneItem = spaceRequiredOneItem;
    }

    public double getSpaceOccupiedAllItems() {
        return spaceOccupiedAllItems;
    }

    public void setSpaceOccupiedAdditionalItems(double addItemsSpace) {
        this.spaceOccupiedAllItems = this.spaceOccupiedAllItems+ addItemsSpace;
    }


    public String getAvailable() {
        if (productQuantityInventory > 0) {
            return "Ready to buy";
        } else {
            return "Sold out";
        }
    }

    public String displayProductInOffer() {
        return "ID "+ productID +
                ", " + productName +
                ": " + String.format("%.2f", priceRetail) +
                ", " + getAvailable() +
                "\n";
    }

    public String displayProductInventory() {
        return "ID "+ productID +
                ", " + productName +
                ", quantity: " + getProductQuantityInventory()+
                ", Space Required for an item: " + String.format("%.2f m3", spaceRequiredOneItem) +
                "\n";
    }

}


