package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Date;
import za.ac.cput.factory.DateFactory;
import za.ac.cput.service.impl.DateServiceImpl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class DateControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private DateController controller;
    @Autowired private TestRestTemplate restTemplate;

    private DateServiceImpl service;
    private Date date;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.date = DateFactory.build("23-10-2022", "Available", "573393", "7574839");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/date/";
    }

    @Test
    @Order(1)
    void safe() {
        String url = baseUrl + "save";
        ResponseEntity<Date> response = this.restTemplate.postForEntity(url, this.date, Date.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.date.getDateNum();
        System.out.println(url);
        ResponseEntity<Date> response = this.restTemplate.getForEntity(url, Date.class);
        System.out.println(response.toString());
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/"+ this.date.getDateNum();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Date[]> response =
                this.restTemplate.getForEntity(url, Date[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
