package src.main.java.za.ac.cput.factory;

/*BookingFactory.java Factory for the BookingFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/
import src.main.java.za.ac.cput.entity.Booking;
import src.main.java.za.ac.cput.util.Helper;

public class BookingFactory {

    public static Booking createBooking(String bookingNum,String clientNum,String date) {
        String bookingId = Helper.generateId();
        Booking booking = new Booking.Builder().setBookingNum(bookingId)
                .setBookingNum(bookingNum)
                .setClientNum(clientNum)
                .build();
        return booking;
    }
}

