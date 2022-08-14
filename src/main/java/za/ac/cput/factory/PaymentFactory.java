package za.ac.cput.factory;

/*  PaymentFactory.java Factory for the PaymentFactory
    Author: Shasta Abrahams (217059376)
    Date: 28 March 2022
*/

import za.ac.cput.entity.Date;
import za.ac.cput.entity.Payment;
import za.ac.cput.util.Helper;


public class PaymentFactory {
    public static Payment build(String paymentNum, String clientNum, String amount, String paymentType, String date, String venueId) {
        //String paymentId = Helper.generateId();
        Payment payment = new Payment.Builder().setPaymentNum(paymentNum)
                .setClientNum(clientNum)
                .setAmount(amount)
                .setPaymentType(paymentType)
                .setDate(date)
                .setVenueId(venueId)
                .build();
        return payment;

        //Helper.checkStringParam("paymentNum", paymentNum);
        //Helper.checkStringParam("clientNum", clientNum);
        //Helper.checkStringParam("amount", amount);
        //Helper.checkStringParam("paymentType", paymentNum);
        //Helper.checkStringParam("date", date);
        //Helper.checkStringParam("venueId", venueId);
        //Helper.checkId(paymentNum);
        //return new Payment().Builder().setPaymentNum(paymentNum).setClientNum(clientNum).setAmount(amount).setPaymentType(paymentNum).setDate(date).setVenueId(venueId).build();

    }
}
