package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;
import za.ac.cput.service.IInventoryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/***
 * InventoryServiceImplTest.java
 * Test implementation for Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 12 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceImplTest {

    private final Inventory inventory = InventoryFactory.build("2098", "Tables", 45, "Not available");

    @Autowired
    private IInventoryService iInventoryService;

    @Order(1)
    @Test
    void save() {
        Inventory saved = this.iInventoryService.save(this.inventory);
        assertEquals(this.inventory, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Inventory> read = this.iInventoryService.read(this.inventory.getItemID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.iInventoryService, read.get())
        );
    }

    //@Order(4)
    @Test
    void delete() {
        this.iInventoryService.deleteById(this.inventory.getItemID());
        List<Inventory> inventoryList = this.iInventoryService.findAll();
        assertEquals(0, inventoryList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Inventory> findAllInventory = this.iInventoryService.findAll();
        assertEquals(1, findAllInventory.size());
    }

}