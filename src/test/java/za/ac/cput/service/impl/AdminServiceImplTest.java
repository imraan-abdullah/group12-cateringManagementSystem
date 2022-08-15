/*
AdminServiceImplTest.java
Author: Ameer Samsodien (220005060)
Date : 13 August 2022
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.IAdminService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class AdminServiceImplTest {

    private final Admin admin = AdminFactory.createAdmin("123", "Lewis", "Hamilton", "lewis@gmail.com", "073 449 8221");

    @Autowired
    private IAdminService service;

    @Order(1)
    @Test
    void save() {
        Admin saved = this.service.save(this.admin);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.admin, saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Admin> read = this.service.read(this.admin.getAdminNum());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.admin, read.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.service.delete(this.admin);
        List<Admin> adminList = this.service.findAll();
        assertEquals(0, adminList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Admin> adminList = this.service.findAll();
        assertEquals(1, adminList.size());
    }

}

/*

    @Test
    void deleteById() {
    }
}

 */