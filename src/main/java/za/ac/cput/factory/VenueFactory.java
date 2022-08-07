package za.ac.cput.factory;
import za.ac.cput.entity.Venue;


/*
 * Inventory.java
 * Factory for the Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 28 March 2022.
 */

public class VenueFactory {

    //Creating venue objects
    public static Venue createVenue(String venueID, String buildingName, int numberOfSeats){
        Venue venue = new Venue.Builder()
                .setVenueID(venueID)
                .setBuildingName(buildingName)
                .setNumberOfSeats(numberOfSeats)
                .build();
        return venue;
    }
}
