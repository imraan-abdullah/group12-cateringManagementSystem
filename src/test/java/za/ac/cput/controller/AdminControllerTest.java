package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private AdminController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Admin admin;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.admin = AdminFactory.createAdmin("33", "Max", "Verstappen", "max@gmail.com","1234567891");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/admin/";
    }

    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        ResponseEntity<Admin> response = this.restTemplate.postForEntity(url, this.admin, Admin.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + this.admin.getAdminNum();
        ResponseEntity<Admin> response = this.restTemplate.getForEntity(url, Admin.class);
        assertAll(
                () ->  assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/" + this.admin.getAdminNum();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "all";
        ResponseEntity<Admin[]> response = this.restTemplate.getForEntity(url, Admin[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertTrue (response.getBody().length == 1)
        );
    }
}