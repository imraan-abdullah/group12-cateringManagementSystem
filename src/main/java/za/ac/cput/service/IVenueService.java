package za.ac.cput.service;

import za.ac.cput.entity.Venue;

import java.util.List;
import java.util.Optional;

/***
 * IVenueService.java
 * Interface implementation for Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 10 August 2022
 */

public interface IVenueService extends IService<Venue, String>{
    Optional<Venue> findById(String id);
    void deleteById(String id);
    List<Venue> findAll();
}
