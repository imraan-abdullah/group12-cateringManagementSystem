package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

/*BookingRepositoryTest.java Test for the BookingRepositoryTest
Author: Mariam Gallie (219094837)
Date: 5 April 2022
*/

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class BookingRepositoryTest {
private static BookingRepository repository = BookingRepository.getRepository();
private static Booking booking = BookingFactory.createBooking("101","1/01/2023");
    @Test
    void a_create() {
        Booking created = repository.create(booking);
        assertEquals(booking.getBookingNum(),created.getBookingNum());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        Booking read = repository.read(booking.getBookingNum());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Booking updated = new Booking.Builder().copy(booking)
                .setClientNum("111")
                .setDate("2/03/2023")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(booking.getBookingNum());
        assertTrue(success);
        System.out.println("Deleted: " + success );

    }

    @Test
    void d_getAll() {
        System.out.println("show all: ");
        System.out.println(repository.getAll());
    }
}