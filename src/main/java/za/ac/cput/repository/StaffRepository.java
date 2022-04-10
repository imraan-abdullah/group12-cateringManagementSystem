package za.ac.cput.repository;

/* StaffRepository.java
 Repository for the Staff
 Author: Velenkosini Prince Jeza (218191669)
 Date: 02 April 2022
*/

import za.ac.cput.entity.Staff;

import java.util.HashSet;
import java.util.Set;

public class StaffRepository implements IStaffRepository {

    private static StaffRepository repository = null;
    private Set<Staff> staffDB = null;

    private StaffRepository()
    {
        staffDB = new HashSet<Staff>();
    }

    public static StaffRepository getRepository()
    {
        if(repository == null)
        {
            repository = new StaffRepository();
        }
        return repository;
    }

    @Override
    public Staff create(Staff staff)
    {
        boolean success = staffDB.add(staff);
        if(!success)
            return null;
        return staff;
    }

    @Override
    public Staff read(String employeeId)
    {
        for (Staff staff : staffDB)
        {
            if(staff.getEmployeeId().equals(employeeId))
                return staff;
        }
        return null;
    }

    @Override
    public Staff update(Staff staff)
    {
        Staff oldStaff = read(staff.getEmployeeId());
        if(oldStaff != null)
        {
            staffDB.remove(oldStaff);
            staffDB.add(staff);
            return staff;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId)
    {
        Staff staffToDelete = read(employeeId);
        if(staffToDelete == null)
            return false;
        staffDB.remove(staffToDelete);
        return true;
    }

    @Override
    public Set<Staff> getAll()
    {

        return staffDB;
    }

}
