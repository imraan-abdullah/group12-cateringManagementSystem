package za.ac.cput.factory;

/*  PaymentFactory.java Factory for the PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Payment;
import za.ac.cput.util.Helper;


public class PaymentFactory {
    public static Payment createPayment(String paymentNum, String clientNum, String amount, String paymentType, String date, String venueId) {
        String paymentId = Helper.generateId();
        Payment payment = new Payment.Builder().setPaymentNum(paymentId)
                .setClientNum(clientNum)
                .setAmount(amount)
                .setPaymentType(paymentType)
                .setDate(date)
                .setVenueId(venueId)
                .build();
        return payment;

    }
}
