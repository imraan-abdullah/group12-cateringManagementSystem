package za.ac.cput.repository;

/*
 * IChefRepository.java repository interface for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Chef;
import java.util.Set;

@Repository
public interface IChefRepository extends JpaRepository<Chef, String>
{

}
