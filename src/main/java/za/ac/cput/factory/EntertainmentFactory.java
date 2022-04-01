package za.ac.cput.factory;

/*
 * EntertainmentFactory.java - factory class for entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 29 March 2022
 * */

import za.ac.cput.entity.Chef;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.util.Helper;

public class EntertainmentFactory
{
    public static Entertainment createEntertainment(String entertainmentType, int cost)
    {
        if(Helper.isNullOrEmpty(entertainmentType))
            return null;

        if(Helper.isNullOrNegitive(cost))
            return null;

        Entertainment entertainment = new Entertainment.Builder().setEntertainmentType(entertainmentType)
                .setCost(cost)
                .build();
        return entertainment;
    }
}
