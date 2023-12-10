package main;

public class Item {
    private Product product;
    private int itemID;
    private int itemQuantity;
    private boolean isValid;
    private String expiryDate;

    public Item(Product product, int itemID, int itemQuantity, boolean isValid, String expiryDate) {
        this.product = product;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.isValid = isValid;
        this.expiryDate = expiryDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
