package za.ac.cput.repository;

/*
 * ChefRepository.java repository class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import za.ac.cput.entity.Chef;
import java.util.HashSet;
import java.util.Set;

public class ChefRepository implements IChefRepository
{
    private static ChefRepository repository = null;
    private Set <Chef> chefDB = null;

    private ChefRepository()
    {
        chefDB = new HashSet<Chef>();
    }

    public static ChefRepository getRepository()
    {
        if(repository == null)
        {
            repository = new ChefRepository();
        }
        return repository;
    }

    @Override
    public Chef create(Chef chef)
    {
        boolean success = chefDB.add(chef);
        if(!success)
            return null;
        return chef;
    }

    @Override
    public Chef read(String employeeId)
    {
        for (Chef chef : chefDB)
        {
            if(chef.getEmployeeId().equals(employeeId))
                return chef;
        }
        return null;
    }

    @Override
    public Chef update(Chef chef)
    {
        Chef oldChef = read(chef.getEmployeeId());
        if(oldChef != null)
        {
            chefDB.remove(oldChef);
            chefDB.add(chef);
            return chef;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId)
    {
        Chef chefToDelete = read(employeeId);
        if(chefToDelete == null)
            return false;
        chefDB.remove(chefToDelete);
        return true;
    }

    @Override
    public Set<Chef> getAll()
    {
        return chefDB;
    }
}
