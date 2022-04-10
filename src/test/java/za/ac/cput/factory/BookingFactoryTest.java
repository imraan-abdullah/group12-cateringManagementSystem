package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {
    @Test
    void createBooking(){
        Booking booking = BookingFactory.createBooking("123","9/02/2023");
        assertNotNull(booking);
        System.out.println(booking);
    }

}