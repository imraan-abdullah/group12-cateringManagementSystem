package za.ac.cput.factory;
import za.ac.cput.entity.Inventory;

/*
 * Inventory.java
 * TDD, Factory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 07 April 2022.
 * Edited 06 August 2022
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    public void testInventoryWithSuccess(){
        Inventory inventory = InventoryFactory.build("ES1", "Aspire ES 15",90, "Available");
        System.out.println(inventory);
        assertNotNull(inventory);

    }

    @Test
    public void testInventoryWithError(){
        Exception exception = assertThrows(IllegalArgumentException
                .class, () -> InventoryFactory.build("", "", 66,  null));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("itemID"));

    }

/*
    @Test
    public void createInventory() {
        Inventory inventory = InventoryFactory.createInventory("4009", "Table", 200, "Available");
        System.out.println(inventory.toString());
        assertNotNull(inventory);
        assertEquals("4009", inventory.getItemID());
    }*/
}