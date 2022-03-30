package za.ac.cput.repository;

import za.ac.cput.entity.WaitingStaff;
import java.util.HashSet;
import java.util.Set;

/*
 * ChefRepository.java repository class for WaitingStaff
 * Author: Imraan Abdullah
 * 219361738
 * Date: 30 March 2022
 * */
public class WaitingStaffRepository implements IWaitingStaffRepository
{
    private static WaitingStaffRepository repository = null;
    private Set <WaitingStaff> waitingStaffDB = null;

    private WaitingStaffRepository()
    {
        waitingStaffDB = new HashSet<WaitingStaff>();
    }

    public static WaitingStaffRepository getRepository()
    {
        if(repository == null)
        {
            repository = new WaitingStaffRepository();
        }
        return repository;
    }

    @Override
    public WaitingStaff create(WaitingStaff waitingStaff)
    {
        boolean success = waitingStaffDB.add(waitingStaff);
        if(!success)
            return null;
        return waitingStaff;
    }

    @Override
    public WaitingStaff read(String employeeId)
    {
        for (WaitingStaff waitingStaff : waitingStaffDB)
        {
            if(waitingStaff.getEmployeeId().equals(employeeId))
                return waitingStaff;
        }
        return null;
    }

    @Override
    public WaitingStaff update(WaitingStaff waitingStaff)
    {
        WaitingStaff oldWaitingStaff = read(waitingStaff.getEmployeeId());
        if(oldWaitingStaff != null)
        {
            waitingStaffDB.remove(oldWaitingStaff);
            waitingStaffDB.add(waitingStaff);
            return waitingStaff;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId)
    {
        WaitingStaff waitingStaffToDelete = read(employeeId);
        if(waitingStaffToDelete == null)
            return false;
        waitingStaffDB.remove(waitingStaffToDelete);
        return true;
    }

    @Override
    public Set<WaitingStaff> getAll()
    {
        return waitingStaffDB;
    }
}
