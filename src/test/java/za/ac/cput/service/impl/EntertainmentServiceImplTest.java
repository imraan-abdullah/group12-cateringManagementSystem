package za.ac.cput.service.impl;

/*
 * EntertainmentServiceImplTest.java Service Test for Entertainment
 * Author: Imraan Abdullah
 * 219361738
 * Date: 10 August 2022
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.factory.EntertainmentFactory;
import za.ac.cput.service.IEntertainmentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EntertainmentServiceImplTest
{
    private final Entertainment entertainment = EntertainmentFactory.build("0126", 5000);

    @Autowired
    private IEntertainmentService service;

    @Order(1)
    @Test
    void save() {
        Entertainment saved = this.service.save(this.entertainment);
        assertAll(
                () -> assertNotNull(saved),
                ()->assertEquals(this.entertainment,saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Entertainment> read = this.service.read(this.entertainment.getEntertainmentType());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                ()-> assertEquals(this.entertainment,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Entertainment> entertainmentList = this.service.findAll();
        assertEquals(this.service.findAll().size(), entertainmentList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.entertainment.getEntertainmentType());
        List<Entertainment> entertainmentList = this.service.findAll();
        assertEquals(this.service.findAll().size(), entertainmentList.size());
    }
}