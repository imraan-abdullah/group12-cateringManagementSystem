package za.ac.cput.entity;

/*
 * Inventory.java
 * Entity for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 26 March 2022
 */
public class Inventory {
    private int itemID;
    private String itemDescription;
    private int itemQuantity;
    private String stockAvailability;

    //Constructor
    private Inventory(Builder builder) {
        this.itemID = builder.itemID;
        this.itemDescription = builder.itemDescription;
        this.itemQuantity = builder.itemQuantity;
        this.stockAvailability = builder.stockAvailability;
    }

    //Getters
    public int getItemID() {
        return itemID;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getStockAvailability() {
        return stockAvailability;
    }

    //toString() method
    @Override
    public String toString() {
        return "Inventory{" +
                "itemID=" + itemID +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", stockAvailability='" + stockAvailability + '\'' +
                '}';
    }

    public static class Builder{
        private int itemID;
        private String itemDescription;
        private int itemQuantity;
        private String stockAvailability;

        //Setters
        public Builder setItemID(int itemID) {
            this.itemID = itemID;
            return this;
        }

        public Builder setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder setItemQuantity(int itemQuantity) {
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder setStockAvailability(String stockAvailability) {
            this.stockAvailability = stockAvailability;
            return this;
        }

        //copy
        public Builder copy(Inventory inventory) {
            this.itemID = inventory.itemID;
            this.itemDescription = inventory.itemDescription;
            this.itemQuantity = inventory.itemQuantity;
            this.stockAvailability = inventory.stockAvailability;
            return this;
        }

        public Inventory build(){
            return new Inventory(this);
        }
    }
}
