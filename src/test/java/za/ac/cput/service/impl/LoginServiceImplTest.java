/*
LoginServiceImplTest.java
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
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.service.ILoginService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LoginServiceImplTest {

    private final Login login = LoginFactory.createLogin("0001","1", "password");

    @Autowired
    private ILoginService service;

    @Order(1)
    @Test
    void save() {
        Login saved = this.service.save(this.login);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.login, saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Login> read = this.service.read(this.login.getLoginId());
        System.out.println("print");
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.login, read.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.service.delete(this.login);
        List<Login> loginList = this.service.findAll();
        assertEquals(this.service.findAll().size(), loginList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Login> loginList = this.service.findAll();
        assertEquals(this.service.findAll().size(), loginList.size());
    }

}

/*

    @Test
    void deleteById() {
    }
}

 */