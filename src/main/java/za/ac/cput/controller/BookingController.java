package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.service.IBookingService;
import javax.validation.Valid;
import java.util.List;

//Mariam Gallie- 219094837
// BookingController.java (controller package)
// 9 October 2022

@RestController
@RequestMapping("cateringManagementSystem/booking/")
@Slf4j
    public class BookingController {
    private final IBookingService iBookingService;

    @Autowired
    public BookingController(IBookingService iBookingService){
        this.iBookingService = iBookingService;
    }
    @PostMapping("save")
    public ResponseEntity<Booking> save(@Valid @RequestBody Booking booking){
        log.info("save request:{}",booking);
        Booking valBooking;
        try {
            valBooking = BookingFactory.build(booking.getBookingNum(), booking.getClientNum(), booking.getDate());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Booking save = iBookingService.save(valBooking);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Booking> read(@PathVariable String id){
        log.info("Read request:{}",id);
        Booking booking = this.iBookingService.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(booking);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.iBookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Booking>>findAll() {
        List<Booking> booking = this.iBookingService.findAll();
        return ResponseEntity.ok(booking);
    }


}
