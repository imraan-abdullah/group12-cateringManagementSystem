package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.WaitingStaff;
import java.util.Set;

/*
 * IWaitingStaffRepository.java repository interface for WaitingStaff
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */
@Repository
public interface IWaitingStaffRepository extends JpaRepository<WaitingStaff, String>
{

}
