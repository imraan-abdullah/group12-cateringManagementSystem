package za.ac.cput.factory;

/*
 * WaitingStaffFactory.java - factory class for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;

public class WaitingStaffFactory
{
    public static WaitingStaff createWaitingStaff(String firstName, String lastName)
    {
        if(src.main.java.za.ac.cput.util.Helper.isNullOrEmpty(firstName) || src.main.java.za.ac.cput.util.Helper.isNullOrEmpty(lastName))
            return null;

        String employeeId = src.main.java.za.ac.cput.util.Helper.generateId();
        WaitingStaff waitingStaff = new WaitingStaff.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return waitingStaff;
    }
}
