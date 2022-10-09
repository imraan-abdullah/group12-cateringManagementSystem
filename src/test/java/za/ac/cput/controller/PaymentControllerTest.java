package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.service.impl.PaymentServiceImpl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PaymentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private PaymentController controller;
    @Autowired private TestRestTemplate restTemplate;

    private PaymentServiceImpl service;
    private Payment payment;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.payment = PaymentFactory.build("3345664", "7648930", "R400", "Cash", "03-11-2022", "354534");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/payment/";
    }

    @Test
    @Order(1)
    void safe() {
        String url = baseUrl + "save";
        ResponseEntity<Payment> response = this.restTemplate.postForEntity(url, this.payment, Payment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.payment.getPaymentNum();
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url, Payment.class);
        System.out.println(response.toString());
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/"+ this.payment.getPaymentNum();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Payment[]> response =
                this.restTemplate.getForEntity(url, Payment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
