package za.ac.cput.factory;

/*
 * ChefFactoryTest.java - test class for ChefFactory
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Chef;

import static org.junit.jupiter.api.Assertions.*;

class ChefFactoryTest {

    @Test
    public void createChef()
    {
        Chef chef = ChefFactory.createChef("imraan", "Abdullah");
        System.out.println(chef.toString());
        assertNotNull(chef);
    }
}