package za.ac.cput.factory;

/*  DateFactory.java Factory for the DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Date;
import za.ac.cput.util.Helper;

public class DateFactory {
    public static Date createDate(String venueAvailability, String venueId, String bookingNum) {
        String dateId = Helper.generateId();
        Date date = new Date.Builder().setDateNum(dateId)
                .setVenueAvailability(venueAvailability)
                .setVenueId(venueId)
                .setBookingNum(bookingNum)
                .build();
        return date;

    }
}