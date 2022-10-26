package za.ac.cput.service.impl;

/*
 * ChefServiceImplTest.java Service Test for Chef
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
import za.ac.cput.entity.Chef;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.service.IChefService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ChefServiceImplTest
{
    private final Chef chef = ChefFactory.build("0124","Imraan", "Abdullah");

    @Autowired
    private IChefService service;

    @Order(1)
    @Test
    void save() {
        Chef saved = this.service.save(this.chef);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.chef,saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Chef> read = this.service.read(this.chef.getEmployeeId());
        System.out.println(read);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.chef,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Chef> chefList = this.service.findAll();
        assertEquals(this.service.findAll().size(), chefList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.chef.getEmployeeId());
        List<Chef> chefList = this.service.findAll();
        assertEquals(this.service.findAll().size(), chefList.size());
    }
}