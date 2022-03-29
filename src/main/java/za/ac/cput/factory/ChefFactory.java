package za.ac.cput.factory;

/*
 * ChefFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;

public class ChefFactory
{
    public static Chef createChef(String firstName, String lastName)
    {
        if(src.main.java.za.ac.cput.util.Helper.isNullOrEmpty(firstName) || src.main.java.za.ac.cput.util.Helper.isNullOrEmpty(lastName))
            return null;

        String employeeId = src.main.java.za.ac.cput.util.Helper.generateId();

        Chef chef = new Chef.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return chef;
    }
}
