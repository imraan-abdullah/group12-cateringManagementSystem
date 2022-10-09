package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

//Mariam Gallie- 219094837
// ClientControllerTest.java (controller Test package)
// 9 October 2022

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ClientControllerTest{
    @LocalServerPort
    private int port;

    @Autowired private ClientController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Client client;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.client = ClientFactory
                .build("8900","Maryam","Doe","mg@gmail.com","0828894632");
        this.baseUrl = "http://localhost:"+ this.port+"/cateringManagementSystem/client/";

    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Client>response = this.restTemplate
                .postForEntity(url,this.client,Client.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.client.getClientNum();
        System.out.println(url);
        ResponseEntity<Client> response = this.restTemplate.getForEntity(url,Client.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void delete(){
        String url = baseUrl + "delete/"+ this.client.getClientNum();
        this.restTemplate.delete(url);
    }
    @Test
    @Order(4)
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Client[]>response =
                this.restTemplate.getForEntity(url,Client[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );
    }
}