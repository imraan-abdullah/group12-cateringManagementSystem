/*
AdminFactoryTest.java
Test class for Admin Factory
Author: Ameer Samsodien (220005060)
Date : 8 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    /*
    @Test
    void createAdmin() {
            Admin admin = AdminFactory.createAdmin("admin2022", "Max", "Verstappen", "admin2022@mycput.ac.za", "061 3289 443");
            System.out.println(admin.toString());
            assertNotNull(admin);
    }
     */

    @Test
    public void buildWithSuccess(){
        Admin admin = AdminFactory.createAdmin("33", "Max", "Verstappen", "max@gmail.com", "1234567891");
        System.out.println(admin);
        assertNotNull(admin);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> AdminFactory.createAdmin("", "", "", "", ""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("adminNum"));
    }

}