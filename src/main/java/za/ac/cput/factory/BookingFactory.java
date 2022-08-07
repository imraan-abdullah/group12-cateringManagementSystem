package za.ac.cput.factory;

/*BookingFactory.java Factory for the BookingFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/
import za.ac.cput.entity.Booking;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

public class BookingFactory {
    //    public static Booking createBooking(String clientNum,String date) {
//        String bookingId = Helper.generateId();
//        Booking booking = new Booking.Builder().setBookingNum(bookingId)
//                .setClientNum(clientNum)
//                .setDate(date)
//                .build();
//        return booking;
//    }
    public static Booking build(String bookingNum ,String clientNum, String date) {
        StringHelper.checkStringParam("bookingNum", bookingNum);
        StringHelper.checkStringParam("clientNum", clientNum);
        StringHelper.checkStringParam("date", date);
        StringHelper.isEmptyOrNull(clientNum);
        StringHelper.isEmptyOrNull(date);
        StringHelper.checkId(bookingNum);
        return new Booking.Builder()
                .setBookingNum(bookingNum)
                .setClientNum(clientNum)
                .setDate(date)
                .build();
    }
}




