package za.ac.cput.repository;

/*
 * ChefRepository.java repository class for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */

import za.ac.cput.entity.Entertainment;
import java.util.HashSet;
import java.util.Set;

public class EntertainmentRepository implements IEntertainmentRepository
{
    private static EntertainmentRepository repository = null;
    private Set <Entertainment> entertainmentDB = null;

    private EntertainmentRepository()
    {
        entertainmentDB = new HashSet<Entertainment>();
    }

    public static EntertainmentRepository getRepository()
    {
        if(repository == null)
        {
            repository = new EntertainmentRepository();
        }
        return repository;
    }

    @Override
    public Entertainment create(Entertainment entertainment)
    {
        boolean success = entertainmentDB.add(entertainment);
        if(!success)
            return null;
        return entertainment;
    }

    @Override
    public Entertainment read(String entertainmentType) {
        for (Entertainment entertainment : entertainmentDB)
        {
            if(entertainment.getEntertainmentType().equals(entertainmentType))
                return entertainment;
        }
        return null;
    }

    @Override
    public Entertainment update(Entertainment entertainment)
    {
        Entertainment oldEntertainment = read(entertainment.getEntertainmentType());
        if(oldEntertainment != null)
        {
            entertainmentDB.remove(oldEntertainment);
            entertainmentDB.add(entertainment);
            return entertainment;
        }
        return null;
    }

    @Override
    public boolean delete(String entertainmentType)
    {
        Entertainment entertainmentToDelete = read(entertainmentType);
        if(entertainmentToDelete == null)
            return false;
        entertainmentDB.remove(entertainmentToDelete);
        return true;
    }

    @Override
    public Set<Entertainment> getAll() {
        return entertainmentDB;
    }
}
