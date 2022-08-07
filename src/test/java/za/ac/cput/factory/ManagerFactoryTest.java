package za.ac.cput.factory;

/* ManagerFactoryTest.java
 Test for ManagerFactory
 Author: Velenkosini Prince Jeza (218191669)
 Date: 08 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Manager;
import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest {

    @Test
    void createManager() {
        Manager manager = ManagerFactory.createManager("55887711", "Mathuli", "Mhlongo");
        System.out.println(manager.toString());
        assertNotNull(manager);
    }
}