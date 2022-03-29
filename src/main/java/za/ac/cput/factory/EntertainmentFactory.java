package za.ac.cput.factory;

/*
 * EntertainmentFactory.java - factory class for entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.Entertainment;

public class EntertainmentFactory
{
    public static Entertainment createEntertainment(String entertainmentType, int cost)
    {
        if(src.main.java.za.ac.cput.util.Helper.isNullOrEmpty(entertainmentType))
            return null;
        if(src.main.java.za.ac.cput.util.Helper.isEmptyOrNegitive(cost))
            return null;

        Entertainment entertainment = new Entertainment.Builder().setEntertainmentType(entertainmentType)
                .setCost(cost)
                .build();
        return entertainment;
    }
}
