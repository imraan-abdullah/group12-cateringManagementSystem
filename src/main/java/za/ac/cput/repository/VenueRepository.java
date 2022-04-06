package za.ac.cput.repository;
import za.ac.cput.entity.Venue;
import za.ac.cput.repository.IVenueRepository;

/*
 * Inventory.java
 * Repository
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 04 April 2022.
 */

import java.util.HashSet;
import java.util.Set;

public class VenueRepository implements IVenueRepository {
    private static VenueRepository venueRepo = null;
    private Set <Venue> venueDB = null;

    //constructor
    private VenueRepository(){
        venueDB = new HashSet <Venue>();
    }

    //testing repository if exists, if not, create a new one.
    public static VenueRepository getVenueRepo(){
        if(venueRepo == null){
            venueRepo = new VenueRepository();
        }
        return venueRepo;
    }

    //methods CRUD
    @Override
    public Venue create(Venue venue) {
        boolean success = venueDB.add(venue);
        if(!success) {
            return null;
        }
        return venue;
    }

    @Override
    public Venue read(String venueID) {          //read with primary key
        for (Venue readVenue : venueDB){
            if (readVenue.getVenueID().equals(venueID)){
                return readVenue;
            }
        }
        return null;
    }

    @Override
    public Venue update(Venue venue) {
        Venue oldVenue = read(venue.getVenueID());
        if(oldVenue != null){
            venueDB.remove(oldVenue);
            venueDB.add(venue);
            return venue;
        }
        return null;
    }

    @Override
    public boolean delete(String venueID) {
        Venue deleteVenue = read(venueID);
        if(deleteVenue == null){
            return false;
        }
        //deleting
        venueDB.remove(deleteVenue);
        return true;
    }

    @Override
    public Set<Venue> getAll() {
        return venueDB;
    }
}
