package main;

public class Storage {
    private String storageID;
    private String storageName;
    private double storageSpaceMaximum;
    private double storageSpaceOccupied;
    private String storageLocation;

    public Storage(String storageID, String storageName, double storageSpaceMaximum, String storageLocation) {
        this.storageID = storageID;
        this.storageName = storageName;
        this.storageSpaceMaximum = storageSpaceMaximum;
        this.storageLocation = storageLocation;
    }

    public double getStorageSpaceAvailable() {
        return storageSpaceMaximum-storageSpaceOccupied;
    }


    public double getStorageSpaceMaximum() {
        return storageSpaceMaximum;
    }

    public void setStorageSpaceMaximum(double storageSpaceMaximum) {
        this.storageSpaceMaximum = storageSpaceMaximum;
    }

    public double getStorageSpaceOccupied() {
        return storageSpaceOccupied;
    }

    public void setStorageSpaceOccupiedAdditionalItems(double AddItemsSpace) {
        this.storageSpaceOccupied = this.storageSpaceOccupied + AddItemsSpace;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getStorageID() {
        return storageID;
    }

    public void setStorageID(String storageID) {
        this.storageID = storageID;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }



    public String displayStorage() {
        return "Storage, ID " + storageID +
                ", Name: " + storageName +
                ", Space Maximum: " + storageSpaceMaximum +
                ", Space Occupied=" + storageSpaceOccupied +
                ", Space Available=" + getStorageSpaceAvailable()  +
                ", Location='" + storageLocation + "\n";
    }

}
