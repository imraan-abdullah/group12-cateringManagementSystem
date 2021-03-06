/*
IAdminRepository.java
Repository interface class for the Admin
Author: Ameer Samsodien (220005060)
Date : 6 April 2022
*/


package za.ac.cput.repository;

import za.ac.cput.entity.Admin;
import java.util.Set;

public interface IAdminRepository extends IRepository <Admin, String>{
    public Set<Admin> getAll();
}
