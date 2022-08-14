/*
ILoginService.java
Author: Ameer Samsodien (220005060)
Date : 12 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.Login;

import java.util.List;

public interface ILoginService extends IService<Login, String>
{
    List<Login> findAll();
    void deleteById(String id);
}
