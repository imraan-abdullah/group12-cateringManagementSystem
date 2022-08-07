/*
package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;

*/
/*
 * Inventory.java
 * TDD, Repository
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 07 April 2022.
 *//*


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class VenueRepositoryTest {

    private static VenueRepository venueRepo = VenueRepository.getVenueRepo();
    private static Venue venue = VenueFactory.createVenue("7709", "Sharpville Hall", 50);


    @Test
    void a_create() {
        Venue created = venueRepo.create(venue);
        assertEquals(venue.getVenueID(), created.getVenueID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Venue read = venueRepo.read(venue.getVenueID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Venue updated = new Venue.Builder().copy(venue)
                .setBuildingName("City Lights Movies")
                .setNumberOfSeats(400)
                .build();
        assertNotNull(venueRepo.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean deleted = venueRepo.delete(venue.getVenueID());
        assertTrue(deleted);
        System.out.println("Deleted:" + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all:");
        System.out.println(venueRepo.getAll());
        assertNotNull(venueRepo.getAll());
    }
}*/
