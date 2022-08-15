package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.service.IStaffService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StaffServiceImplTest {



    private final Staff staff = StaffFactory.createStaff("15516","Jaime", "Zaid", "Permanent");

    @Autowired
    private IStaffService service;

    @Order(1)
    @Test
    void save() {
        Staff saved = this.service.save(this.staff);
        System.out.println(saved.toString());
        assertAll(
                () -> assertNotNull(saved),

        ()->assertEquals(this.staff,saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Staff> read = this.service.read(this.staff.getEmployeeId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),

                ()->assertEquals(this.staff,read.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.staff.getEmployeeId());
        List<Staff> StaffList = this.service.findAll();
        assertEquals(0, StaffList.size());
    }

    @Order(3)
    @Test
    void findAll() {
        List<Staff> StaffList = this.service.findAll();
        assertEquals(1, StaffList.size());
    }
}
