package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ManagerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private ManagerController controller;

    @Autowired private TestRestTemplate restTemplate;

    private Manager manager;

    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.manager = ManagerFactory.createManager("4585", "Philip", "Jones");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/manager/";
    }

    @Test
    @Order(1)
    void safe() {
        String url = baseUrl + "save";
        ResponseEntity<Manager> response = this.restTemplate.postForEntity(url, this.manager, Manager.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.manager.getEmployeeId();
        ResponseEntity<Manager> response = this.restTemplate.getForEntity(url, Manager.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/" + this.manager.getEmployeeId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl+ "all" ;
        ResponseEntity<Manager[]> response = this.restTemplate.getForEntity(url, Manager[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}