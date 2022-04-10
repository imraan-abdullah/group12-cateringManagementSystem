package za.ac.cput.factory;

/*  PaymentFactory.java Factory for the PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {
    public static Payment createPayment(String amount, String paymentType, String date, String venueId) {
        /*if (!Helper.isNullOrEmpty(clientNum))
            return null;

        if (!Helper.isNullOrEmpty(venueId) || Helper.isNullOrEmpty(amount))
            return null;

        if (!Helper.isNullOrEmpty(paymentType) || Helper.isNullOrEmpty(date))
            return null;

         */
        String clientId = Helper.generateId();
        Payment payment = new Payment.Builder().setClientNum(clientId)
                .setAmount(amount)
                .setPaymentType(paymentType)
                .setDate(date)
                .setVenueId(venueId)
                .build();
        return payment;
        //return new Payment.Builder().setClientNum(clientNum)
        //        .setAmount(amount)
        //        .setPaymentType(paymentType)
        //        .setDate(date)
        //        .setVenueId(venueId)
        //        .build();
    }
}
