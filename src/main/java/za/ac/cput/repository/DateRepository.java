package za.ac.cput.repository;

/*
 * DateRepository.java repository interface
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import za.ac.cput.entity.Date;

import java.util.HashSet;
import java.util.Set;

public class DateRepository implements IDateRepository {
    private static DateRepository repository = null;
    private Set<Date> dateDB = null;

    private DateRepository() {
        dateDB = new HashSet<Date>();
    }

    public static DateRepository getRepository() {
        if (repository == null) {
            repository = new DateRepository();
        }
        return repository;
    }

    @Override
    public Date create(Date date) {
        boolean success = dateDB.add(date);
        if (!success)
            return null;
        return date;
    }

    @Override
    public Date read(String bookingNum) {
        /*for(Date d : dateDB)
            if (d.getVenueId().equals(venueId))
                return d;
        return null;
         */
        Date date = dateDB.stream()
                .filter(e-> e.getBookingNum().equals(bookingNum))
                .findAny()
                .orElse(null);
        return date;
    }

    @Override
    public Date update(Date date) {
        Date oldDate = read(date.getBookingNum());
        if (oldDate != null) {
            dateDB.remove(oldDate);
            dateDB.add(date);
            return date;
        }
        return null;
    }

    @Override
    public boolean delete(String bookingNum) {
        Date dateToDelete = read(bookingNum);
        if (bookingNum == null)
            return false;
        dateDB.remove(dateToDelete);
        return true;
    }

    @Override
    public Set<Date> getAll() {
        return dateDB;
    }
}
