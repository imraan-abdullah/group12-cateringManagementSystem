package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Venue;
import za.ac.cput.repository.IVenueRepository;
import za.ac.cput.service.IVenueService;

import java.util.List;
import java.util.Optional;

/***
 * VenueServiceImpl.java
 * Service implementation for Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 10 August 2022
 */

@Service
public class VenueServiceImpl implements IVenueService {
    private final IVenueRepository repository;

    @Autowired
    public VenueServiceImpl(IVenueRepository repo) {
        this.repository = repo;

    }

    @Override
    public Venue save(Venue venue) {
        return this.repository.save(venue);
    }

    @Override
    public Optional<Venue> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Venue venue) {
        repository.delete(venue);
    }

    @Override
    public Optional<Venue> findById(String itemID) {
        return this.repository.findById(itemID);
    }

    public List<Venue> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String itemID) {
        Optional<Venue> Venue = read(itemID);
        if(Venue.isPresent()) delete(Venue.get());
    }
}
