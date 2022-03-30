package za.ac.cput.repository;

/*
 * IEntertainmentRepository.java repository interface for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import za.ac.cput.entity.Entertainment;
import java.util.Set;

public interface IEntertainmentRepository extends IRepository <Entertainment, String>
{
    public Set<Entertainment> getAll();
}
