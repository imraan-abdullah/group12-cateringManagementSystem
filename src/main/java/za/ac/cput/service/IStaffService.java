package za.ac.cput.service;

import za.ac.cput.entity.Staff;
import java.util.List;

public interface IStaffService extends IService<Staff, String>{
    List<Staff> findAll();
    void deleteById(String id);
}
