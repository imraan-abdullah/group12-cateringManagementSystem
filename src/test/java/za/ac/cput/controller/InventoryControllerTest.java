package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.*;
import za.ac.cput.factory.*;

/***
 * InventoryControllerTest.java
 * Test case for InventoryController
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 20 August 2022
 */
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryControllerTest {
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
        ResponseEntity<Inventory> response = this.template.postForEntity(url, this.inventory, Inventory.class);
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
        System.out.println(url);
        ResponseEntity<Inventory> response = this.template.getForEntity(url, Inventory.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.inventory.getItemID();
        this.template.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Inventory[]> response = this.template.getForEntity(url, Inventory[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}