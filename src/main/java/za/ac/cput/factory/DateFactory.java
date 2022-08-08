package za.ac.cput.factory;

/*  DateFactory.java Factory for the DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import lombok.Data;
import za.ac.cput.entity.Date;
import za.ac.cput.util.Helper;

public class DateFactory {
    public static Date build(String dateNum, String venueAvailability, String venueId, String bookingNum) {
        String dateId = Helper.generateId();
        Date date = new Date.Builder().setDateNum(dateId)
                .setVenueAvailability(venueAvailability)
                .setVenueId(venueId)
                .setBookingNum(bookingNum)
                .build();
        return date;

        //Helper.checkStringParam("dateNum", dateNum);
        //Helper.checkStringParam("venueAvailability", venueAvailability);
        //Helper.checkStringParam("venueId", venueId);
        //Helper.checkStringParam("bookingNum", bookingNum);
        //Helper.checkId(dateNum);
        //return new Date().Builder().setDateNum(dateNum).setVenueAvailability(venueAvailability).setVenueId(venueId).setBookingNum(bookingNum).build();


    }
}