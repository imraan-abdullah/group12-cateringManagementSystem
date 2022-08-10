package za.ac.cput.factory;

/*
 * WaitingStaffFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

public class WaitingStaffFactory
{
    public static WaitingStaff createWaitingStaff(String WaitingStaffId,String firstName, String lastName)
    {
        StringHelper.checkStringParam(" WaitingStaffId",  WaitingStaffId);
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        StringHelper.isEmptyOrNull(firstName);
        StringHelper.isEmptyOrNull(lastName);

        return new WaitingStaff.Builder().setId(WaitingStaffId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
