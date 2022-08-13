package za.ac.cput.service.impl;
//Mariam Gallie - 219094837
//updated: 13 August 2022

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Booking;
import za.ac.cput.repository.IBookingRepository;
import za.ac.cput.service.IBookingService;

import java.util.List;
import java.util.Optional;


    @Service
    public class BookingServiceImpl implements IBookingService {

        private final IBookingRepository repository;

        @Autowired
        public BookingServiceImpl(IBookingRepository repository){

            this.repository = repository;
        }
        @Override
        public Booking save (Booking booking){

            return this.repository.save(booking);
        }
        @Override
        public Optional<Booking> read(String s){

            return this.repository.findById(s);
        }
        @Override
        public void delete(Booking booking){

            this.repository.delete(booking);
        }
        @Override
        public List<Booking> findAll(){

            return this.repository.findAll();
        }

        public void deleteById(String id){
            Optional <Booking> booking = read(id);
            if (booking.isPresent())delete(booking.get());
        }
    }


