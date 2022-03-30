package za.ac.cput.repository;

/*
 * IChefRepository.java repository interface for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import za.ac.cput.entity.Chef;
import java.util.Set;

public interface IChefRepository extends IRepository <Chef, String>
{
    public Set<Chef> getAll();
}
