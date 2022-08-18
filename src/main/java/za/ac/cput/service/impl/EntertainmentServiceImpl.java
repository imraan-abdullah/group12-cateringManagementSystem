package za.ac.cput.service.impl;

/*
 * EntertainmentService.java Service for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 10 August 2022
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Chef;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.repository.IEntertainmentRepository;
import za.ac.cput.service.IEntertainmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EntertainmentServiceImpl implements IEntertainmentService
{
    private final IEntertainmentRepository repository;

    @Autowired
    public EntertainmentServiceImpl(IEntertainmentRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Entertainment save(Entertainment entertainment) {
        return this.repository.save(entertainment);
    }

    @Override
    public Optional<Entertainment> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Entertainment entertainment) {
        this.repository.delete(entertainment);
    }

    @Override
    public List<Entertainment> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Entertainment> entertainment = read(id);
        if(entertainment.isPresent())
            delete(entertainment.get());
    }
}
