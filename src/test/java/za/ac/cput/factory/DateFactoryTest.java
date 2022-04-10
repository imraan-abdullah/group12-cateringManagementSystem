package za.ac.cput.factory;

/*  DateFactoryTest.java Test for DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 6 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateFactoryTest {

    @Test
    public void testDate() {
        Date date = DateFactory.createDate("Available", "56567", "90909");
        assertNotNull(date);
    }
}
