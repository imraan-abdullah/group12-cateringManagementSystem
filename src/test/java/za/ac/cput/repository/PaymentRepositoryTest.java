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
    private static Payment payment = PaymentFactory.createPayment("500.00", "Cash", "2022/10/11", "21212");

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertEquals(payment.getClientNum(),created.getClientNum());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Payment read = repository.read(payment.getClientNum());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setAmount("800.00")
                .setPaymentType("Card")
                .setDate("2022/11/23")
                .setVenueId("23451")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(payment.getClientNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
