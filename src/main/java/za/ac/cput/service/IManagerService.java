package za.ac.cput.service;

import za.ac.cput.entity.Manager;

import java.util.List;

public interface IManagerService extends IService<Manager, String>{
        List<Manager> findAll();
        void deleteById(String id);
}
