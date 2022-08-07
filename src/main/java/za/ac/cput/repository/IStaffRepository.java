package za.ac.cput.repository;

/* IStaffRepository.java
 Interface Repository for the Staff
 Author: Velenkosini Prince Jeza (218191669)
 Date: 02 April 2022
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Staff;
import java.util.Set;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, String>
{
}
