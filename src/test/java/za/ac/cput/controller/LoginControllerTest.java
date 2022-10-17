/*
LoginControllerTest.java
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
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LoginControllerTest {

    public static String ADMIN_SECURITY_USERNAME = "login-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "login-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

    @LocalServerPort
    private int port;

    @Autowired private LoginController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Login login;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.login = LoginFactory
                .createLogin("16", "33", "password");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/login/";
    }


    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Login> entity = new HttpEntity<>(login, headers);
        ResponseEntity<Login>response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, Login.class);

        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }


    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + this.login.getLoginId();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Login> response = this.restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Login.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete()
    {
        String url = baseUrl + "delete/" + this.login.getLoginId();
        //this.restTemplate.delete(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Login> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, entity, Login.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    @Order(4)
    void findAll()
    {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = this.restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());

        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}