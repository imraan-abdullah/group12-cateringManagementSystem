package za.ac.cput.factory;

/*  DateFactory.java Factory for the DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Date;
import za.ac.cput.util.Helper;

public class DateFactory {
    public static Date createDate(String venueAvailability, String venueId) {
        /*if (!Helper.isNullOrEmpty(venueId))
            return null;

        if (Helper.isNullOrEmpty(venueAvailability) || Helper.isNullOrEmpty(bookingNum))
            return null;

         */
        String bookingId = Helper.generateId();
        Date date = new Date.Builder().setBookingNum(bookingId)
                .setVenueAvailability(venueAvailability)
                .setVenueId(venueId)
                .build();
                return date;
    }
}