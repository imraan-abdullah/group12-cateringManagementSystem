package za.ac.cput.factory;

/*  PaymentFactoryTest.java Test for PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 6 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFactoryTest {

    @Test
    public void testPayment() {
        Payment payment = PaymentFactory.createPayment("475839", "23343", "600.00", "Cash", "2022/10/22", "34575");
        assertNotNull(payment);
    }
}
