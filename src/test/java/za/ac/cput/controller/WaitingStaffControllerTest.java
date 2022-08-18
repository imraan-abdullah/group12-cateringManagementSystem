package za.ac.cput.controller;

/*
 * WaitingStaffControllerTest.java Controller Test for WaitingStaff
 * Author: Imraan Abdullah
 * 219361738
 * Date: 18 August 2022
 * */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.factory.WaitingStaffFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class WaitingStaffControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private WaitingStaffController controller;
    @Autowired private TestRestTemplate restTemplate;

    private WaitingStaff waitingStaff;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.waitingStaff = WaitingStaffFactory.build("0125", "Imraan", "Abdullah");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/waitingStaff/";
    }

    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        ResponseEntity<WaitingStaff> response = this.restTemplate.postForEntity(url, this.waitingStaff, WaitingStaff.class);
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
        String url = baseUrl + "read/" + this.waitingStaff.getEmployeeId();
        ResponseEntity<WaitingStaff> response = this.restTemplate.getForEntity(url, WaitingStaff.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/"+ this.waitingStaff.getEmployeeId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "all";
        ResponseEntity<WaitingStaff[]> response = this.restTemplate.getForEntity(url, WaitingStaff[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}