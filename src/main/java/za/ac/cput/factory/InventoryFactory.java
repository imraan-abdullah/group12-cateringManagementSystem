package za.ac.cput.factory;
import za.ac.cput.entity.Inventory;
import za.ac.cput.util.StringHelper;

/*
 * Inventory.java
 * Factory for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 28 March 2022.
 * Edited 05 August 2022
 */

public class InventoryFactory {

    public static Inventory build(String itemID, String itemDescription, int itemQuantity, String stockAvailability){
        StringHelper.checkStringParam("itemID", itemID);
        StringHelper.checkStringParam("itemDescription", itemDescription);
        StringHelper.isNullOrNegative(itemQuantity);
        StringHelper.checkStringParam("sockAvailability", stockAvailability);
        return new Inventory.Builder()
                .setItemID(itemID)
                .setItemDescription(itemDescription)
                .setItemQuantity(itemQuantity)
                .setStockAvailability(stockAvailability)
                .build();

    }

/*    //Creating inventory objects
    public static Inventory createInventory(String itemID, String itemDescription, int itemQuantity, String stockAvailability){
        Inventory inventory = new Inventory.Builder()
                .setItemID(itemID)
                .setItemDescription(itemDescription)
                .setItemQuantity(itemQuantity)
                .setStockAvailability(stockAvailability)
                .build();
        return inventory;
    }*/
}
