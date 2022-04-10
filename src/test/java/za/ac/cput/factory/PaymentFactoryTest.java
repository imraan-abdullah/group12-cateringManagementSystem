package za.ac.cput.factory;

/*  PaymentFactoryTest.java Test for PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 6 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;
import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    public void testPayment() {
        Payment payment = PaymentFactory.createPayment("800.00", "Cash", "2022/11/11", "23456");
        //System.out.println(payment.toString());
        assertNotNull(payment);
    }
}
