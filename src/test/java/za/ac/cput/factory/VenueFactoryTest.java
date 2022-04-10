package za.ac.cput.factory;
import za.ac.cput.entity.Venue;

/*
 * Inventory.java
 * TDD, Factory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 07 April 2022.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VenueFactoryTest {

    @Test
    public void createVenue() {
        Venue venue = VenueFactory.createVenue("2209", "Bluelight Hall", 50);
        System.out.println(venue);
        assertNotNull(venue);
        assertEquals("2209", venue.getVenueID());
    }
}