package za.ac.cput.service;

/*
 * IEntertainmentService.java Service for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 10 August 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.Entertainment;

import java.util.List;

public interface IEntertainmentService extends IService<Entertainment, String>
{
    List<Entertainment> findAll();
    void deleteById(String id);
}
