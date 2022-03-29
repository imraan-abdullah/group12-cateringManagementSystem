package za.ac.cput.factory;

/*  DateFactory.java Factory for the DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Date;

public class DateFactory {
    public static Date createDate(String venueAvailability, String venueId, String bookingNum) {
        if (venueAvailability.equals("") || venueAvailability == null)
            return null;

        if (venueId.equals("") || venueId == null)
            return null;

        if (bookingNum.equals("") || bookingNum == null)
            return null;

        return new Date.Builder().setVenueAvailability(venueAvailability)
                .setVenueId(venueId)
                .setBookingNum(bookingNum)
                .build();

    }
}