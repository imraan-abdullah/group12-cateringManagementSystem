package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Date;
import za.ac.cput.repository.IDateRepository;
import za.ac.cput.service.IDateService;

import java.util.List;
import java.util.Optional;

@Service
public class DateServiceImpl implements IDateService {
    private final IDateRepository repository;

    @Autowired
    public DateServiceImpl (IDateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Date save (Date date) {
        return this.repository.save(date);
    }

    @Override
    public Optional<Date>read(String dateNum) {
        return this.repository.findById(dateNum);
    }

    @Override
    public void delete(Date date) {
        this.repository.delete(date);
    }

    @Override
    public List<Date> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Date> date = read(id);
        if(date.isPresent())
            delete(date.get());
    }
}
