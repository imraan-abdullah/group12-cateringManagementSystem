package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

//Mariam Gallie -219094837
// BookingControllerTest.java (controller Test package)
// 9 October 2022

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Chef;
import za.ac.cput.factory.BookingFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BookingControllerTest{

    public static String ADMIN_SECURITY_USERNAME = "booking-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "booking-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

    @LocalServerPort
    private int port;

    @Autowired private BookingController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Booking booking;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.booking = BookingFactory
                .build("9999","A0123","23 September 2022");
        this.baseUrl = "http://localhost:"+ this.port+"/cateringManagementSystem/booking/";

    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
//        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Booking> entity = new HttpEntity<Booking>(booking, headers);
        ResponseEntity<Booking>response = this.restTemplate
                  .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                  .exchange(url, HttpMethod.POST, entity, Booking.class);
//                .postForEntity(url,this.booking,Booking.class);
//        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.booking.getBookingNum();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Booking> response = this.restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Booking.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void delete(){
        String url = baseUrl + "delete/"+ this.booking.getBookingNum();
//        this.restTemplate.delete(url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Booking> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, entity, Booking.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    @Order(4)
    void findAll(){
        String url = baseUrl + "all";
//        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String>response = restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());

        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}