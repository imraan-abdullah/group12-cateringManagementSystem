package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;
import za.ac.cput.service.IVenueService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/***
 * VenueServiceImplTest.java
 * Test implementation for Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 12 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VenueServiceImplTest {

    private  final Venue venue = VenueFactory.build("BUS125S", "Business and Commerce", 564);

    @Autowired
    private IVenueService iVenueService;

    @Order(1)
    @Test
    void save() {
        Venue venue1 = this.iVenueService.save(venue);
        assertEquals(this.venue, venue1);
        System.out.println(venue1);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Venue> venueOptional = this.iVenueService.read(this.venue.getVenueID());
        assertAll(
                () -> assertTrue(venueOptional.isPresent()),
                () -> assertEquals(this.venue, venueOptional.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.iVenueService.deleteById(this.venue.getVenueID());
        List<Venue> venueList = this.iVenueService.findAll();
        assertEquals(0, venueList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Venue> findAllVenue = this.iVenueService.findAll();
        assertEquals(1, findAllVenue.size());

    }
}