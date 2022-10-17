/*
LoginFactoryTest.java
Test class for Login Factory
Author: Ameer Samsodien (220005060)
Date : 8 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Login;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    /*
    @Test
    void createLogin() {
        Login login = LoginFactory.createLogin("0001","admin2022", "123password");
        assertNotNull(login);
        System.out.println(login);
    }
     */

    @Test
    public void buildWithSuccess(){
        Login login = LoginFactory.createLogin("16", "33", "password");
        System.out.println(login);
        assertNotNull(login);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> LoginFactory.createLogin("", "",""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("loginId"));
    }

}