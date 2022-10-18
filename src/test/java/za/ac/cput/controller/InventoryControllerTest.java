package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.entity.*;
import za.ac.cput.factory.*;

/***
 * InventoryControllerTest.java
 * Test case for InventoryController
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 15 October 2022
 */
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryControllerTest {
    public static String ADMIN_SECURITY_USERNAME = "inventory-admin";
    public static String ADMIN_SECURITY_PASSWORD = "12345";
    public static String CLIENT_SECURITY_USERNAME = "inventory-client";
    public static String CLIENT_SECURITY_PASSWORD = "54321";

    @LocalServerPort
    private int port;

    @Autowired private InventoryController controller;
    @Autowired private TestRestTemplate template;

    private Inventory inventory;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.inventory = InventoryFactory.build("2097", "Bags", 987, "Available");
        this.baseUrl = "http://localhost:" + this.port + "/cateringManagementSystem/inventory/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Inventory> httpEntity = new HttpEntity<Inventory>(inventory, httpHeaders);
        ResponseEntity<Inventory> response = this.template.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.POST, httpEntity, Inventory.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.inventory.getItemID();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        //System.out.println(url);
        ResponseEntity<Inventory> response = this.template.withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET, httpEntity, Inventory.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.inventory.getItemID();
        //this.template.delete(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<Inventory> response = this.template.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, httpEntity, Inventory.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = this.template.withBasicAuth(CLIENT_SECURITY_USERNAME, CLIENT_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}