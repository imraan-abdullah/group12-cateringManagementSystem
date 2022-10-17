/*
AdminControllerTest.java
Author: Ameer Samsodien (220005060)
Date : 9 October 2022
*/

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class AdminControllerTest {

    public static String ADMIN_SECURITY_USERNAME = "admin-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "admin-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

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

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Admin> entity = new HttpEntity<>(admin, headers);
        ResponseEntity<Admin> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME,ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, Admin.class);

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

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Admin> response = restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME,CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Admin.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/" + this.admin.getAdminNum();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Admin> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME,ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, entity, Admin.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME,CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}