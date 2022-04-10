package za.ac.cput.factory;
import za.ac.cput.entity.Inventory;
import za.ac.cput.util.Helper;

/*
 * Inventory.java
 * Factory for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 28 March 2022.
 */

public class InventoryFactory {

    //Creating inventory objects
    public static Inventory createInventory(String itemID, String itemDescription, int itemQuantity, String stockAvailability){
        Inventory inventory = new Inventory.Builder()
                .setItemID(itemID)
                .setItemDescription(itemDescription)
                .setItemQuantity(itemQuantity)
                .setStockAvailability(stockAvailability)
                .build();
        return inventory;
    }
}
