package za.ac.cput.factory;

/* StaffFactoryTest.java
 Test for StaffFactory
 Author: Velenkosini Prince Jeza (218191669)
 Date: 06 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Staff;
import static org.junit.jupiter.api.Assertions.*;

class StaffFactoryTest {

    @Test
    void createStaff() {
        Staff staff = StaffFactory.createStaff("55887711", "Mathuli", "Mhlongo", "Temporal");
        System.out.println(staff.toString());
        assertNotNull(staff);
    }
}