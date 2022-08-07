package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Venue;

/*
 * Inventory.java
 * Interface
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 04 April 2022.
 * Edited 05 August 2022
 */

import java.util.Set;

public interface IVenueRepository extends JpaRepository<Venue, String> {
    //public Set <Venue> getAll();

}
