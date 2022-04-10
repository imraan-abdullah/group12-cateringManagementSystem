package za.ac.cput.repository;

/* IManagerRepository.java
 Interface Repository for the Manager
 Author: Velenkosini Prince Jeza (218191669)
 Date: 02 April 2022
*/

import za.ac.cput.entity.Manager;

import java.util.Set;

public interface IManagerRepository extends IRepository <Manager, String>
{
    public Set<Manager> getAll();
}
