package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Inventory;
import za.ac.cput.repository.IInventoryRepository;
import za.ac.cput.service.IInventoryService;

import java.util.List;
import java.util.Optional;

/***
 * InventoryServiceImpl.java
 * Service implementation for Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 10 August 2022
 */

@Service
public class InventoryServiceImpl implements IInventoryService {
    private final IInventoryRepository repository;

    @Autowired
    public InventoryServiceImpl(IInventoryRepository repo) {
        this.repository = repo;

    }

    @Override
    public Inventory save(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Optional<Inventory> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Inventory inventory) {
        repository.delete(inventory);
    }

    public List<Inventory> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Inventory> findById(String itemID) {
        return this.repository.findById(itemID);
    }

    @Override
    public void deleteById(String itemID) {
        Optional<Inventory> Inventory = read(itemID);
        if(Inventory.isPresent()) delete(Inventory.get());
    }
}
