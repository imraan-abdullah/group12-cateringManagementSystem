package za.ac.cput.repository;

/*
 * IEntertainmentRepository.java repository interface for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Entertainment;
import java.util.Set;

@Repository
public interface IEntertainmentRepository extends JpaRepository<Entertainment, String>
{

}
