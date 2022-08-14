package za.ac.cput.service;

import za.ac.cput.entity.Inventory;

import java.util.List;
import java.util.Optional;

/***
 * IInventoryService.java
 * Interface implementation for Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 10 August 2022
 */

public interface IInventoryService extends IService<Inventory, String>{
    Optional<Inventory> findById(String id);
    void deleteById(String itemID);
    List<Inventory> findAll();
}
