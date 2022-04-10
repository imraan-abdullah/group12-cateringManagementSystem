/*
ILoginRepository.java
Repository interface class for the Login
Author: Ameer Samsodien (220005060)
Date : 6 April 2022
*/


package za.ac.cput.repository;

import za.ac.cput.entity.Login;
import java.util.Set;

public interface ILoginRepository extends IRepository <Login, String>{
    public Set<Login> getAll();
}
