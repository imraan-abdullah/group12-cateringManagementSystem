package za.ac.cput.controller;

/*
 * ChefControllerTest.java Controller Test for Chef
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
import za.ac.cput.entity.Chef;
import za.ac.cput.factory.ChefFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ChefControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private ChefController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Chef chef;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.chef = ChefFactory.build("0124", "Imraan", "Abdullah");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/chef/";
    }

    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        ResponseEntity<Chef> response = this.restTemplate.postForEntity(url, this.chef, Chef.class);
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
        String url = baseUrl + "read/" + this.chef.getEmployeeId();
        ResponseEntity<Chef> response = this.restTemplate.getForEntity(url, Chef.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/"+ this.chef.getEmployeeId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "all";
        ResponseEntity<Chef[]> response = this.restTemplate.getForEntity(url, Chef[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}