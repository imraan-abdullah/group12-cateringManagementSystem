package za.ac.cput.factory;

/*  PaymentFactory.java Factory for the PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Payment;

public class PaymentFactory {
    public static Payment createPayment(String clientNum, String amount, String paymentType, String date, String venueId) {
        if (clientNum.equals("") || clientNum == null)
            return null;

        if (amount.equals("") || amount == null)
            return null;

        if (paymentType.equals("") || paymentType == null)
            return null;

        if (date.equals("") || date == null)
            return null;

        if (venueId.equals("") || venueId == null)
            return null;

        return new Payment.Builder().setClientNum(clientNum)
                .setAmount(amount)
                .setPaymentType(paymentType)
                .setDate(date)
                .setVenueId(venueId)
                .build();
    }
}
