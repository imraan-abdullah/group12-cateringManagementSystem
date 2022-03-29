package za.ac.cput.factory;

/*
 * WaitingStaffFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.util.Helper;

public class WaitingStaffFactory
{
    public static WaitingStaff createWaitingStaff(String firstName, String lastName)
    {

        String employeeId = Helper.generateId();

        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

        WaitingStaff waitingStaff = new WaitingStaff.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return waitingStaff;
    }
}
