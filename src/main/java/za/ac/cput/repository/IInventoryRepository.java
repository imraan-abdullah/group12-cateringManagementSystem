package za.ac.cput.repository;

import za.ac.cput.entity.Inventory;

/*
 * Inventory.java
 * Interface
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 04 April 2022.
 */

import java.util.Set;

public interface IInventoryRepository extends IRepository <Inventory, String>{
    public Set <Inventory> getAll();

}

