package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Chef;
import za.ac.cput.repository.IChefRepository;
import za.ac.cput.service.IChefService;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements IChefService {
    private final IChefRepository repository;

    @Autowired
    public ChefServiceImpl(IChefRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Chef save(Chef chef) {
        return this.repository.save(chef);
    }

    @Override
    public Optional<Chef> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Chef chef) {
        this.repository.delete(chef);
    }

    @Override
    public List<Chef> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Chef> chef = read(id);
        if(chef.isPresent())
            delete(chef.get());
    }
}
