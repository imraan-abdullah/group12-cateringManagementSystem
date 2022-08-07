package za.ac.cput.factory;
import za.ac.cput.entity.Venue;
import za.ac.cput.util.StringHelper;


/*
 * Inventory.java
 * Factory for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 28 March 2022.
 * Edited 06 August 2022
 */

public class VenueFactory {

    public static Venue build(String venueID, String buildingName, int numberOfSeats){
        StringHelper.checkStringParam("venueID", venueID);
        StringHelper.checkStringParam("buildingName", buildingName);
        StringHelper.isNullOrNegative(numberOfSeats);
        return new Venue.Builder()
                .setVenueID(venueID)
                .setBuildingName(buildingName)
                .setNumberOfSeats(numberOfSeats)
                .build();
    }
/*    //Creating venue objects
    public static Venue createVenue(String venueID, String buildingName, int numberOfSeats){
        Venue venue = new Venue.Builder()
                .setVenueID(venueID)
                .setBuildingName(buildingName)
                .setNumberOfSeats(numberOfSeats)
                .build();
        return venue;
    }*/
}
