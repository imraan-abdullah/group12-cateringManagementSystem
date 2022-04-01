package za.ac.cput.factory;


import za.ac.cput.entity.Staff;
import za.ac.cput.util.Helper;

/* Staff.java
 Entity for the Staff
 Author: Velenkosini Prince Jeza (218191669)
 Date: 29 March 2022
*/

public class StaffFactory {

    public static Staff createStaff (String employeeId, String firstName, String lastName, String staffType){

        if(employeeId == null || employeeId.equals("") || employeeId.matches(".*[a-zA-Z]+.*"))
            return null;

        if(firstName == null || firstName.equals(""))
            return null;

        if(lastName == null || lastName.equals(""))
            return null;

        if(staffType == null || staffType.equals(""))
            return null;

        return new Staff.Builder()
                .setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStaffType(staffType)
                .build();
    }
}
