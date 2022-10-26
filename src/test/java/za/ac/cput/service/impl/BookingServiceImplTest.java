package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.service.IBookingService;
//Mariam Gallie - 219094837
//updated: 13 August 2022

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceImplTest {
    private final Booking booking = BookingFactory.build("111","34m","23/05/2023");
    @Autowired
    private IBookingService service;

        @Order(1)
        @Test
        void save() {
            Booking saved = this.service.save(this.booking);
            assertAll(
                    ()->assertNotNull(saved),
                    ()->assertEquals(this.booking,saved)
            );
        }

        @Order(2)
        @Test
        void read() {
            Optional<Booking> read = this.service.read(this.booking.getBookingNum());
            System.out.println(read);
            assertAll(
                    ()-> assertTrue(read.isPresent()),
                    ()->assertEquals(this.booking,read.get())
            );
        }
        @Order(4)
        @Test void delete(){
            this.service.delete(this.booking);
            List<Booking> bookingList = this.service.findAll();
            assertEquals(this.service.findAll().size(), bookingList.size());
        }

        @Order(3)
        @Test
        void findAll() {
            List<Booking> bookingList = this.service.findAll();
            assertEquals(this.service.findAll().size(),bookingList.size());
        }
    }


