package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;

import static org.junit.jupiter.api.Assertions.*;
//Updated by Mariam Gallie-219094837
//Updated: 6 August 2022
class BookingFactoryTest {
//    @Test
//    void createBooking(){
//        Booking booking = BookingFactory.createBooking("123","9/02/2023");
//        assertNotNull(booking);
//        System.out.println(booking);
//    }

    @Test
    public void buildWithSuccess(){
    Booking booking = BookingFactory.build("111","50","23/05/2023");
    System.out.println(booking);
    assertNotNull(booking);
}
    @Test
    public void buidWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> BookingFactory.build("", "",""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("bookingNum"));
    }

}