package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.*;
import za.ac.cput.factory.*;

/***
 * VenueControllerTest.java
 * Test case for VenueController
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 20 August 2022
 */

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VenueControllerTest {
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
        ResponseEntity<Venue> response = this.template.postForEntity(url, this.venue, Venue.class);
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
        System.out.println(url);
        ResponseEntity<Venue> response = this.template.getForEntity(url, Venue.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
            String url = baseUrl + "delete/" + this.venue.getVenueID();
            this.template.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Venue[]> response = this.template.getForEntity(url, Venue[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}