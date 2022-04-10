package za.ac.cput.repository;

import za.ac.cput.entity.Booking;

import java.util.Set;

public interface IBookingRepository extends IRepository <Booking,String>{
    public Set<Booking> getAll();
}
