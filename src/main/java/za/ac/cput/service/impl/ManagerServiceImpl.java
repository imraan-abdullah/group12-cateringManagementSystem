package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Manager;
import za.ac.cput.repository.IManagerRepository;
import za.ac.cput.service.IManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements IManagerService {

    private final IManagerRepository repository;

    @Autowired
    public ManagerServiceImpl(IManagerRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Manager save(Manager manager) {
        return this.repository.save(manager);
    }

    @Override
    public Optional<Manager> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Manager manager) {
        this.repository.delete(manager);
    }

    @Override
    public List<Manager> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Manager> manager = read(id);
        if(manager.isPresent())
            delete(manager.get());
    }

}
