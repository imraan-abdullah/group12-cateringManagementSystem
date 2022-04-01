package za.ac.cput.factory;

import za.ac.cput.entity.Manager;
import za.ac.cput.util.Helper;


/* Staff.java
 Entity for the Staff
 Author: Velenkosini Prince Jeza (218191669)
 Date: 29 March 2022
*/

public class ManagerFactory {

    public static Manager createManager(String employeeId, String firstName, String lastName){
        if(employeeId == null || employeeId.equals("") || employeeId.matches(".*[a-zA-Z]+.*"))
            return null;

        if(firstName == null || firstName.equals(""))
            return null;

        if(lastName == null || lastName.equals(""))
            return null;

        return new Manager.Builder()
                .setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
