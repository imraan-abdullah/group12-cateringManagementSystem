/*
AdminServiceImpl.java
Author: Ameer Samsodien (220005060)
Date : 12 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Admin;
import za.ac.cput.repository.IAdminRepository;
import za.ac.cput.service.IAdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {
    private final IAdminRepository repository;

    @Autowired
    public AdminServiceImpl(IAdminRepository repository)
    {this.repository = repository;}

    @Override
    public Admin save(Admin admin)
    {return this.repository.save(admin);}

    @Override
    public Optional<Admin> read(String id)
    {return this.repository.findById(id);}

    @Override
    public void delete(Admin admin)
    {this.repository.delete(admin);}

    @Override
    public List<Admin> findAll()
    {return this.repository.findAll();}

    @Override
    public void deleteById(String id){
        Optional<Admin> admin = read(id);
        if (admin.isPresent())delete(admin.get());
    }
}
