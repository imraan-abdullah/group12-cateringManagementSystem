package za.ac.cput.repository;

/* ManagerRepository.java
 Repository for the Manager
 Author: Velenkosini Prince Jeza (218191669)
 Date: 03 April 2022
*/

import za.ac.cput.entity.Manager;

import java.util.HashSet;
import java.util.Set;

public class ManagerRepository implements IManagerRepository {

    private static ManagerRepository repository = null;
    private Set<Manager> managerDB = null;

    private ManagerRepository()
    {
        managerDB = new HashSet<Manager>();
    }

    public static ManagerRepository getRepository()
    {
        if(repository == null)
        {
            repository = new ManagerRepository();
        }
        return repository;
    }

    @Override
    public Manager create(Manager manager)
    {
        boolean success = managerDB.add(manager);
        if(!success)
            return null;
        return manager;
    }

    @Override
    public Manager read(String employeeId)
    {
        for (Manager manager : managerDB)
        {
            if(manager.getEmployeeId().equals(employeeId))
                return manager;
        }
        return null;
    }

    @Override
    public Manager update(Manager manager)
    {
        Manager oldManager = read(manager.getEmployeeId());
        if(oldManager != null)
        {
            managerDB.remove(oldManager);
            managerDB.add(manager);
            return manager;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId)
    {
        Manager managerToDelete = read(employeeId);
        if(managerToDelete == null)
            return false;
        managerDB.remove(managerToDelete);
        return true;
    }

    @Override
    public Set<Manager> getAll()
    {

        return managerDB;
    }
}
