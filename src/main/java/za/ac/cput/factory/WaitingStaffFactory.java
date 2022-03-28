package za.ac.cput.factory;

import za.ac.cput.entity.WaitingStaff;

public class WaitingStaffFactory
{
    public static WaitingStaff createWaitingStaff(String employeeId, String firstName, String lastName)
    {
        if(employeeId == null || employeeId.equals("") || employeeId.matches(".*[a-zA-Z]+.*"))
            return null;

        if(firstName == null || firstName.equals(""))
            return null;

        if(lastName == null || lastName.equals(""))
            return null;

        return new WaitingStaff.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
