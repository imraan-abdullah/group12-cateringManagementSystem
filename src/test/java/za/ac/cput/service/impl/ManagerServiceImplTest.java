package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;
import za.ac.cput.service.IManagerService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerServiceImplTest {

    private final Manager manager = ManagerFactory.createManager("15516","Jaime", "Zaid");

    @Autowired
    private IManagerService service;

    @Order(1)
    @Test
    void save() {
        Manager saved = this.service.save(this.manager);
        System.out.println(saved.toString());
        assertAll(
                () -> assertNotNull(saved),
                ()->assertEquals(this.manager,saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Manager> read = this.service.read(this.manager.getEmployeeId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                ()->assertEquals(this.manager,read.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.manager.getEmployeeId());
        List<Manager> ManagerList = this.service.findAll();
        assertEquals(this.service.findAll().size(), ManagerList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Manager> ManagerList = this.service.findAll();
        assertEquals(this.service.findAll().size(), ManagerList.size());
    }

}
