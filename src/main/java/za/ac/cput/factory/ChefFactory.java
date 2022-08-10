package za.ac.cput.factory;

/*
 * ChefFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

public class ChefFactory
{
    public static Chef createChef(String chefId ,String firstName, String lastName)
    {
        StringHelper.checkStringParam("chefId", chefId);
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        StringHelper.isEmptyOrNull(firstName);
        StringHelper.isEmptyOrNull(lastName);

        return new Chef.Builder().setEmployeeId(chefId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
