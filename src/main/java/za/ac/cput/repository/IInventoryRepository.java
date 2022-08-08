package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Inventory;

/*
 * Inventory.java
 * Interface
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 04 April 2022.
 * Edited 06 August 2022
 */

import java.util.Set;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, String> {
    //public Set <Inventory> getAll();

}

