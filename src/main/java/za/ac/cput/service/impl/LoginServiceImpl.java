/*
LoginServiceImpl.java
Author: Ameer Samsodien (220005060)
Date : 12 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Login;
import za.ac.cput.repository.ILoginRepository;
import za.ac.cput.service.ILoginService;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService{

    private final ILoginRepository repository;

    @Autowired
    public LoginServiceImpl(ILoginRepository repository)
    {this.repository = repository;}

    @Override
    public Login save(Login login)
    {return this.repository.save(login);}

    @Override
    public Optional<Login> read(String id)
    {return this.repository.findById(id);}

    @Override
    public void delete(Login login)
    {this.repository.delete(login);}

    @Override
    public List<Login> findAll()
    {return this.repository.findAll();}

    public void deleteById(String id){
        Optional <Login> login = read(id);
        if(login.isPresent())delete(login.get());
    }
}
