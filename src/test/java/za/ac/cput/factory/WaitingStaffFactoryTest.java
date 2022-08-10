package za.ac.cput.factory;

/*
 * WaitingStaffFactoryTest.java - test class for WaitingStaffFactory
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.WaitingStaff;

import static org.junit.jupiter.api.Assertions.*;

class WaitingStaffFactoryTest {

    @Test
    public void createWaitingStaff()
    {
        WaitingStaff waitingStaff = WaitingStaffFactory.createWaitingStaff("0125", "Tasneem", "Upadhe");
        System.out.println(waitingStaff.toString());
        assertNotNull(waitingStaff);
    }
}