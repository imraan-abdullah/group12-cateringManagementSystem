package za.ac.cput.service.impl;
//Mariam Gallie - 219094837
//updated: 13 August 2022
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.service.IBookingService;
import za.ac.cput.service.IClientService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ClientServiceImplTest {

    private final Client client = ClientFactory.build("54G","Mike","Ross","mike@gmail.com",
            "0793423768");
    @Autowired
    private IClientService service;

    @Order(1)
    @Test
    void save() {
        Client saved = this.service.save(this.client);
        assertAll(
                ()->assertNotNull(saved),

                ()->assertEquals(this.client,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Client> read = this.service.read(this.client.getClientNum());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.client,read.get())
        );
    }
    @Order(4)
    @Test void delete(){
        this.service.delete(this.client);
        List<Client> clientList = this.service.findAll();
        assertEquals(0, clientList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Client> clientList = this.service.findAll();
        assertEquals(1,clientList.size());
    }
}