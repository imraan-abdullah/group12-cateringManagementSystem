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
import za.ac.cput.util.StringHelper;

public class EntertainmentFactory
{
    public static Entertainment createEntertainment(String entertainmentType, int cost)
    {

        StringHelper.checkStringParam("entertainmentType", entertainmentType);
        StringHelper.isNullOrNegative(cost);

        return new Entertainment.Builder().setEntertainmentType(entertainmentType)
                .setCost(cost)
                .build();
    }
}
