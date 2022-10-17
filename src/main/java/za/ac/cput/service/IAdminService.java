/*
IAdminService.java
Author: Ameer Samsodien (220005060)
Date : 12 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.Admin;
import java.util.List;

public interface IAdminService extends IService <Admin, String> {
    List<Admin> findAll();
    void deleteById(String id);
}
