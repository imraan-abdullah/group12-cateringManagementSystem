package za.ac.cput.service;

/*
 * IChefService.java Service for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 10 August 2022
 * */

import za.ac.cput.entity.Chef;
import java.util.List;

public interface IChefService extends IService<Chef, String>
{
    List<Chef> findAll();
    void deleteById(String id);
}
