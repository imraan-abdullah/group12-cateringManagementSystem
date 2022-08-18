package za.ac.cput.factory;

/*
 * WaitingStaffFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.util.StringHelper;

public class WaitingStaffFactory
{
    public static WaitingStaff build(String WaitingStaffId, String firstName, String lastName)
    {
        StringHelper.checkStringParam("waitingStaffId", WaitingStaffId);
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        StringHelper.isEmptyOrNull(firstName);
        StringHelper.isEmptyOrNull(lastName);
        StringHelper.checkId(WaitingStaffId);

        return new WaitingStaff.Builder()
                .setEmployeeId(WaitingStaffId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
