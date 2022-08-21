package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Date;
import za.ac.cput.factory.DateFactory;
import za.ac.cput.service.IDateService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/date/")
@Slf4j

public class DateController {

    private final IDateService service;

    @Autowired
    public DateController(IDateService service) {this.service = service;}

    @PostMapping("save")
    public ResponseEntity<Date> save(@Valid @RequestBody Date date) {
        log.info("Save request:{}", date);
        Date newDate;
        try {
            newDate = DateFactory.build(date.getDateNum(),date.getVenueAvailability(), date.getVenueId(), date.getBookingNum());
        }
        catch(IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Date save = service.save(newDate);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Date> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Date date = this.service.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(date);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Date>> findAll() {
        List <Date> date = this.service.findAll();
        return ResponseEntity.ok(date);
    }
}
