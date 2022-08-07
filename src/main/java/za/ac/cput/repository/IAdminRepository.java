/*
IAdminRepository.java
Repository interface class for the Admin
Author: Ameer Samsodien (220005060)
Date : 6 April 2022
*/


package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Admin;
import java.util.Set;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, String> {

}
