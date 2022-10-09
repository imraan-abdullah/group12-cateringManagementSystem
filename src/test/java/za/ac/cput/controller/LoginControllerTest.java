package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

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
        this.login = LoginFactory.createLogin("16", "33", "password");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/login/";
    }

    @Test
    @Order(1)
    void safe()
    {
        String url = baseUrl + "save";
        ResponseEntity<Login> response = this.restTemplate.postForEntity(url,this.login,Login.class);
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
        String url = baseUrl + "read/" + this.login.getLoginId();
        ResponseEntity<Login> response = this.restTemplate.getForEntity(url, Login.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete()
    {
        String url = baseUrl + "delete/" + this.login.getLoginId();
        this.restTemplate.delete(url);
    }

    @Test
    void findAll()
    {
        String url = baseUrl + "all";
        ResponseEntity<Login[]> response = this.restTemplate.getForEntity(url, Login[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}