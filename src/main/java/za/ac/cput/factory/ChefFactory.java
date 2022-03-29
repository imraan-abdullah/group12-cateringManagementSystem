package za.ac.cput.factory;

/*
 * ChefFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.util.Helper;

public class ChefFactory
{
    public static Chef createChef(String firstName, String lastName)
    {
        String employeeId = Helper.generateId();

        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

        Chef chef = new Chef.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return chef;
    }
}
