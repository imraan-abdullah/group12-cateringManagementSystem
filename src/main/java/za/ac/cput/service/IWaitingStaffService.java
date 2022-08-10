package za.ac.cput.service;

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;

import java.util.List;

public interface IWaitingStaffService extends IService<WaitingStaff, String>
{
    List<WaitingStaff> findAll();
    void deleteById(String id);
}
