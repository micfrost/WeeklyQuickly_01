package main;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double priceProducer;
    private double priceRetail;
    private int quantityInventory;
    private int quantityOrdered;
    private String available;
    private double spaceRequired;




    public Product(String productId, String productName, double priceRetail) {
        this.productId = productId;
        this.productName = productName;
        this.priceRetail = priceRetail;
    }

    public Product(String productId, String productName, double priceProducer, double priceRetail, int quantityInventory, double spaceRequired) {
        this.productId = productId;
        this.productName = productName;
        this.priceProducer = priceProducer;
        this.priceRetail = priceRetail;
        this.quantityInventory = quantityInventory;
        this.spaceRequired = spaceRequired;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public void setQuantityInventory(int quantityInventory) {
        this.quantityInventory = quantityInventory;
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

    public String getAvailable() {
        if (quantityInventory > 0) {
            return "Ready to buy";
        } else {
            return "Sold out";
        }
    }

    public String displayProductOrder() {
        return "ID "+ productId +
                ", " + productName +
                ": " + String.format("%.2f", priceRetail) +
                ", " + getAvailable() +
                "\n";
    }

    public String displayProductInventory() {
        return "ID "+ productId +
                ", " + productName +
                ", quantity: " + getQuantityInventory()+
                ", Space Required for an item: " + String.format("%.2f m3", spaceRequired) +
                "\n";
    }

}


