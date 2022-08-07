package za.ac.cput.factory;

/*  DateFactoryTest.java Test for DateFactory
    Author: Shasta Abrahams (217059376)
    Date: 6 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateFactoryTest {

    //@Test
    //public void testDate() {
    //    Date date = DateFactory.createDate("Available", "56567", "90909");
    //    assertNotNull(date);
    //}

    @Test
    public void buildWithSuccess() {
        Date date = DateFactory.build("22-10-2019", "available", "546543", "3456774");
        System.out.println(date);
        assertNotNull(date);
    }

    @Test public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateFactory.build("","","",""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("dateNum"));
    }
}
