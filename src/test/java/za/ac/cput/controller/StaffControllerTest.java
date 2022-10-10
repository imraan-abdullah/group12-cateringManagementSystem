package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StaffControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StaffController controller;

    @Autowired private TestRestTemplate restTemplate;

    private Staff staff;

    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.staff = StaffFactory.createStaff("4585", "Philip", "Jones", "Temporal");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/staff/";
    }

    @Test
    @Order(1)
    void safe() {
        String url = baseUrl + "save";
        ResponseEntity<Staff> response = this.restTemplate.postForEntity(url, this.staff, Staff.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.staff.getEmployeeId();
        ResponseEntity<Staff> response = this.restTemplate.getForEntity(url, Staff.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/" + this.staff.getEmployeeId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl+ "all" ;
        ResponseEntity<Staff[]> response = this.restTemplate.getForEntity(url, Staff[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}