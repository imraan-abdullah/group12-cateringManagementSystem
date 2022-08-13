package za.ac.cput.service;
//Mariam Gallie - 219094837
//updated: 13 August 2022


import za.ac.cput.entity.Booking;

import java.util.List;

public interface IBookingService extends IService <Booking,String>{
    List<Booking> findAll();

    void deleteById( String Id);

}
