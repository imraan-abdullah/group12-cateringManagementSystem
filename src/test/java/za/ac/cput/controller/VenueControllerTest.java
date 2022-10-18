package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.*;
import za.ac.cput.factory.*;

/***
 * VenueControllerTest.java
 * Test case for VenueController
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 15 October 2022
 */

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VenueControllerTest {
    public static String ADMIN_SECURITY_USERNAME = "venue-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "venue-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

    @LocalServerPort
    private int port;

    @Autowired private VenueController controller;
    @Autowired private TestRestTemplate template;

    private Venue venue;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.venue = VenueFactory.build("IDC207", "Advanced Department", 30);
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/venue/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Venue> httpEntity = new HttpEntity<Venue>(venue, httpHeaders);
        ResponseEntity<Venue> response = this.template.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, httpEntity, Venue.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.venue.getVenueID();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        //System.out.println(url);
        ResponseEntity<Venue> response = this.template.withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, httpEntity, Venue.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.venue.getVenueID();
        //this.template.delete(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<Venue> response = this.template.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, httpEntity, Venue.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = this.template.withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}