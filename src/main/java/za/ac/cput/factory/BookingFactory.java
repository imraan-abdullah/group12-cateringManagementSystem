package za.ac.cput.factory;

/*BookingFactory.java Factory for the BookingFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/
import za.ac.cput.entity.Booking;
import za.ac.cput.util.Helper;

public class BookingFactory {

    public static Booking createBooking(String bookingNum,String clientNum,String date) {
        String bookingId = Helper.generateId();
        Booking booking = new Booking.Builder().setBookingNum(bookingId)
                .setBookingNum(bookingNum)
                .setClientNum(clientNum)
                .setDate(date)
                .build();
        return booking;
    }
}

