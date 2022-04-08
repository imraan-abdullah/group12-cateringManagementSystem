package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;

/*
 * Inventory.java
 * TDD, Repository
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 07 April 2022.
 */

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryRepositoryTest {

    private static InventoryRepository inventoryRepo = InventoryRepository.getInventoryRepo();
    private static Inventory inventory = InventoryFactory.createInventory("2987", "Table and Seats", 300,"Available");

    @Test
    void a_create() {
        Inventory created = inventoryRepo.create(inventory);
        assertEquals(inventory.getItemID(), created.getItemID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Inventory read = inventoryRepo.read(inventory.getItemID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Inventory updated = new Inventory.Builder().copy(inventory).setItemDescription("Tent")
                                .build();
        assertNotNull(inventoryRepo.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean deleted = inventoryRepo.delete(inventory.getItemID());
        assertTrue(deleted);
        System.out.println("Deleted:" + deleted);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(inventoryRepo.getAll());
        assertNotNull(inventoryRepo.getAll());
    }
}