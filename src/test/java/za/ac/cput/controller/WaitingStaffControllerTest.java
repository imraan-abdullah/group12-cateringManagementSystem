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
import org.springframework.http.*;
import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.factory.WaitingStaffFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class WaitingStaffControllerTest
{
    public static String ADMIN_SECURITY_USERNAME = "waitingStaff-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "waitingStaff-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

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

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<WaitingStaff> entity = new HttpEntity<WaitingStaff>(waitingStaff, headers);
        ResponseEntity<WaitingStaff> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, WaitingStaff.class);

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

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<WaitingStaff> response = restTemplate
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, WaitingStaff.class);

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

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<WaitingStaff> response = restTemplate
                .withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, entity, WaitingStaff.class);

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
                .withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}