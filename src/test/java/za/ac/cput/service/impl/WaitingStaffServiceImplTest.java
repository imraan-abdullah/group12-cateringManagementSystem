package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.factory.WaitingStaffFactory;
import za.ac.cput.service.IWaitingStaffService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WaitingStaffServiceImplTest
{

    private final WaitingStaff waitingStaff = WaitingStaffFactory.build("0125","Imraan", "Abdullah");

    @Autowired
    private IWaitingStaffService service;

    @Order(1)
    @Test
    void save() {
        WaitingStaff saved = this.service.save(this.waitingStaff);
        System.out.println(saved.toString());
        assertAll(
                () -> assertNotNull(saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<WaitingStaff> read = this.service.read(this.waitingStaff.getEmployeeId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<WaitingStaff> waitingStaffList = this.service.findAll();
        assertEquals(1, waitingStaffList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.waitingStaff.getEmployeeId());
        List<WaitingStaff> waitingStaffList = this.service.findAll();
        assertEquals(0, waitingStaffList.size());
    }
}