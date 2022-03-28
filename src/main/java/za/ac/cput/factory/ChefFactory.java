package za.ac.cput.factory;

import za.ac.cput.entity.Chef;

public class ChefFactory
{
    public static Chef createChef(String employeeId, String firstName, String lastName)
    {
        if(employeeId == null || employeeId.equals("") || employeeId.matches(".*[a-zA-Z]+.*"))
            return null;

        if(firstName == null || firstName.equals(""))
            return null;

        if(lastName == null || lastName.equals(""))
            return null;

        return new Chef.Builder().setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
