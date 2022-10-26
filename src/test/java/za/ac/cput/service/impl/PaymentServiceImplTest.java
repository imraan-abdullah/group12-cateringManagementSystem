package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Date;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.service.IPaymentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PaymentServiceImplTest {
    private final Payment payment = PaymentFactory.build("4563556", "3456353", "R590", "Card", "22-10-2019", "54352");

    @Autowired
    private IPaymentService service;

    @Order(1)
    @Test
    void save() {
        Payment saved = this.service.save(this.payment);
        assertAll(
                ()-> assertNotNull(saved),
                ()-> assertEquals(this.payment,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Payment> read = this.service.read(this.payment.getPaymentNum());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.payment,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Payment> paymentList = this.service.findAll();
        assertEquals(this.service.findAll().size(),paymentList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.payment.getPaymentNum());
        List<Payment> paymentList = this.service.findAll();
        assertEquals(this.service.findAll().size(), paymentList.size());
    }
}
