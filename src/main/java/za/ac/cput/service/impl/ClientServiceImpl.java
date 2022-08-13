package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Client;
import za.ac.cput.repository.IClientRepository;
import za.ac.cput.service.IClientService;

import java.util.List;
import java.util.Optional;
//Mariam Gallie - 219094837
//updated: 13 August 2022


@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository repository;

    @Autowired
    public ClientServiceImpl(IClientRepository repository){

        this.repository = repository;
    }
    @Override

    public Client save (Client client){
        return this.repository.save(client);
    }
    @Override
    public Optional<Client> read(String s){
        return this.repository.findById(s);
    }
    @Override
    public void delete(Client client){

        this.repository.delete(client);
    }
    @Override
    public List<Client> findAll(){

        return this.repository.findAll();
    }

    public void deleteById(String id){
        Optional <Client> client = read(id);
        if (client.isPresent())delete(client.get());
    }
}
