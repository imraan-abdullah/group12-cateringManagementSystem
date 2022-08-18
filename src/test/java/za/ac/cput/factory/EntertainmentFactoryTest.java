package za.ac.cput.factory;

/*
 * EntertainmentFactoryTest.java - test class for EntertainmentFactory
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Entertainment;

import static org.junit.jupiter.api.Assertions.*;

class EntertainmentFactoryTest {

    @Test
    public void createEntertainment()
    {
        Entertainment entertainment = EntertainmentFactory.build("Music", 5000);
        System.out.println(entertainment.toString());
        assertNotNull(entertainment);
    }
}