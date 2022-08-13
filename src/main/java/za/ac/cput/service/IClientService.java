package za.ac.cput.service;
//Mariam Gallie - 219094837
//updated: 13 August 2022

import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Client;

import java.util.List;

public interface IClientService extends IService<Client,String>{

    List<Client> findAll();

    void deleteById( String Id);
}
