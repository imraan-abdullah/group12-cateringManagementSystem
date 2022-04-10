package za.ac.cput.repository;

/*
 * PaymentRepositoryTest.java test class for PaymentRepository
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class PaymentRepositoryTest {
    private static PaymentRepository repository = PaymentRepository.getRepository();
    private static Payment payment = PaymentFactory.createPayment("565656", "567493", "600.00", "Cash", "2022/10/22", "21212");

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertEquals(payment.getPaymentNum(), created.getPaymentNum());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Payment read = repository.read(payment.getPaymentNum());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setClientNum("4747738")
                .setAmount("800.00")
                .setPaymentType("Card")
                .setDate("2022/09/09")
                .setVenueId("745775")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(payment.getPaymentNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
