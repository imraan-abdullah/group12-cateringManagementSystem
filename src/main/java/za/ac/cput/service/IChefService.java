package za.ac.cput.service;

import za.ac.cput.entity.Chef;

import java.util.List;

public interface IChefService extends IService<Chef, String>
{
    List<Chef> findAll();
    void deleteById(String id);
}
