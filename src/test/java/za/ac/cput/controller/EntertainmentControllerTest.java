package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.factory.EntertainmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EntertainmentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EntertainmentController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Entertainment entertainment;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.entertainment = EntertainmentFactory.build("music", 5000);
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/entertainment/";
    }

    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        ResponseEntity<Entertainment> response = this.restTemplate.postForEntity(url, this.entertainment, Entertainment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + this.entertainment.getEntertainmentType();
        ResponseEntity<Entertainment> response = this.restTemplate.getForEntity(url, Entertainment.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/"+ this.entertainment.getEntertainmentType();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "all";
        ResponseEntity<Entertainment[]> response = this.restTemplate.getForEntity(url, Entertainment[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}