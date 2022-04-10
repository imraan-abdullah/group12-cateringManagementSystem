package za.ac.cput.repository;

/*
 * PaymentRepository.java repository interface
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import za.ac.cput.entity.Payment;
import java.util.HashSet;
import java.util.Set;

public class PaymentRepository implements IPaymentRepository {
    private static PaymentRepository repository = null;
    private Set<Payment> paymentDB = null;

    private PaymentRepository() {
        paymentDB = new HashSet<Payment>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean success = paymentDB.add(payment);
        if (!success)
            return null;
        return payment;
    }

    @Override
    public Payment read(String clientNum) {
        /*for(Payment p : paymentDB)
            if (p.getVenueId().equals(clientNum))
                return p;
        return null;

         */
        Payment payment = paymentDB.stream()
                .filter(e-> e.getClientNum().equals(clientNum))
                .findAny()
                .orElse(null);
        return payment;
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment = read(payment.getClientNum());
        if (oldPayment != null) {
            paymentDB.remove(oldPayment);
            paymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String clientNum) {
        Payment paymentToDelete = read(clientNum);
        if (clientNum == null)
            return false;
        paymentDB.remove(paymentToDelete);
        return true;
    }

    @Override
    public Set<Payment> getAll() {
        return paymentDB;
    }
}
