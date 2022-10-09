package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

//Mariam Gallie -219094837
// BookingControllerTest.java (controller Test package)
// 9 October 2022

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BookingControllerTest{
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
        System.out.println(url);
        ResponseEntity<Booking>response = this.restTemplate
                .postForEntity(url,this.booking,Booking.class);
        System.out.println(response);
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
        ResponseEntity<Booking> response = this.restTemplate.getForEntity(url, Booking.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void delete(){
        String url = baseUrl + "delete/"+ this.booking.getBookingNum();
        this.restTemplate.delete(url);
    }
    @Test
    @Order(4)
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Booking[]>response =
                this.restTemplate.getForEntity(url,Booking[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );
    }
}