package za.ac.cput.entity;

/*
 * Inventory.java
 * Entity for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 26 March 2022.
 * Edited 05 August 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Inventory implements Serializable { //allows us to convert an Object to stream
    @NotNull @Id private String itemID;
    @NotNull private String itemDescription;
    @NotNull private int itemQuantity;
    @NotNull private String stockAvailability;

    //Constructor
    private Inventory(Builder builder) {
        this.itemID = builder.itemID;
        this.itemDescription = builder.itemDescription;
        this.itemQuantity = builder.itemQuantity;
        this.stockAvailability = builder.stockAvailability;
    }

    public Inventory() {

    }

    //Getters
    public String getItemID() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Inventory inventory = (Inventory) o;
        return itemQuantity == inventory.itemQuantity &&
                itemID.equals(inventory.itemID) &&
                itemDescription.equals(inventory.itemDescription) &&
                stockAvailability.equals(inventory.stockAvailability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, itemDescription, itemQuantity, stockAvailability);
    }

    public static class Builder{
        private String itemID;
        private String itemDescription;
        private int itemQuantity;
        private String stockAvailability;

        //Setters
        public Builder setItemID(String itemID) {
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
