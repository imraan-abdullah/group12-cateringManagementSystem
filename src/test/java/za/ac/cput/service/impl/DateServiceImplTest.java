package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Date;
import za.ac.cput.factory.DateFactory;
import za.ac.cput.service.IDateService;

import java.util.List;
import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class DateServiceImplTest {
    private final Date date = DateFactory.build("22-10-2019", "available", "54362364", "45754");

    @Autowired
    private IDateService service;

    @Order(1)
    @Test
    void save() {
        Date saved = this.service.save(this.date);
        assertAll(
                () -> assertNotNull(saved),

                ()->assertEquals(this.date,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Date> read = this.service.read(this.date.getDateNum());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.date,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Date> dateList = this.service.findAll();
        assertEquals(1,dateList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.deleteById(this.date.getDateNum());
        List<Date> dateList = this.service.findAll();
        assertEquals(0, dateList.size());
    }
}
