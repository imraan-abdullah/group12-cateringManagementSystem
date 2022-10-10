package za.ac.cput.factory;

/*  DateFactory.java Factory for the DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Date;
import za.ac.cput.util.StringHelper;

public class DateFactory {
    public static Date build(String dateNum, String venueAvailability, String venueId, String bookingNum) {
        StringHelper.checkStringParam("dateNum", dateNum);
        StringHelper.checkStringParam("venueAvailability", venueAvailability);
        StringHelper.checkStringParam("venueId", venueId);
        StringHelper.checkStringParam("bookingNum", bookingNum);
        StringHelper.isEmptyOrNull(venueAvailability);
        StringHelper.isEmptyOrNull(venueId);
        StringHelper.isEmptyOrNull(bookingNum);
        StringHelper.checkId(dateNum);

        return  new Date.Builder().setDateNum(dateNum)
                .setVenueAvailability(venueAvailability)
                .setVenueId(venueId)
                .setBookingNum(bookingNum)
                .build();
    }
}