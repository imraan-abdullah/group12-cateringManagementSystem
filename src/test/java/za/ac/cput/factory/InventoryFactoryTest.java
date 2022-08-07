package za.ac.cput.factory;
import za.ac.cput.entity.Inventory;

/*
 * Inventory.java
 * TDD, Factory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 07 April 2022.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    public void createInventory() {
        Inventory inventory = InventoryFactory.createInventory("4009", "Table", 200, "Available");
        System.out.println(inventory.toString());
        assertNotNull(inventory);
        assertEquals("4009", inventory.getItemID());
    }
}