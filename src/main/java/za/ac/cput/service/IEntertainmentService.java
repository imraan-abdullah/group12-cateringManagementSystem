package za.ac.cput.service;

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.Entertainment;

import java.util.List;

public interface IEntertainmentService extends IService<Entertainment, String>
{
    List<Entertainment> findAll();
    void deleteById(String id);
}
