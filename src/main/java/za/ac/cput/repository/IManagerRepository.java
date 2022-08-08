package za.ac.cput.repository;

/* IManagerRepository.java
 Interface Repository for the Manager
 Author: Velenkosini Prince Jeza (218191669)
 Date: 02 April 2022
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Manager;

import java.util.Set;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, String>
{

}
