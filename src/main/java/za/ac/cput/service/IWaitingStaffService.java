package za.ac.cput.service;

/*
 * IWaitingStaffService.java Service for WaitingStaff
 * Author: Imraan Abdullah
 * 219361738
 * Date: 10 August 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;

import java.util.List;

public interface IWaitingStaffService extends IService<WaitingStaff, String>
{
    List<WaitingStaff> findAll();
    void deleteById(String id);
}
