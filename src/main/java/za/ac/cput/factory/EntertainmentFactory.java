package za.ac.cput.factory;

import za.ac.cput.entity.Entertainment;

public class EntertainmentFactory
{
    public static Entertainment createEntertainment(String entertainmentType, int cost)
    {
        if(entertainmentType == null || entertainmentType.equals("") || entertainmentType.matches(".*\\d.*"))
            return null;

        if(cost == 0 || cost<0)
            return null;

        return new Entertainment.Builder().setEntertainmentType(entertainmentType)
                .setCost(cost)
                .build();
    }
}
