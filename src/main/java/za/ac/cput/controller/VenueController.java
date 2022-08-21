package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.*;

import javax.validation.Valid;
import java.util.List;

/***
 * VenueController.java
 * Controller for Venue
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 19 August 2022
 */

@RestController
@RequestMapping("cateringManagementSystem/venue/")
@Slf4j
public class VenueController {
    private IVenueService venueService;

    @Autowired
    public VenueController(IVenueService iVenueService){
        this.venueService = iVenueService;
    }

    @PostMapping("save")
    public ResponseEntity<Venue> save(@Valid @RequestBody Venue venue){
        log.info("Save request:{}", venue);
        Venue venue1;
        try{
            venue1 = VenueFactory.build(venue.getVenueID(), venue.getBuildingName(), venue.getNumberOfSeats());
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Venue save = venueService.save(venue1);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{venueID}")
    public ResponseEntity<Venue> read(@PathVariable String venueID){
        log.info("Read request:{}", venueID);
        Venue venue = this.venueService.read(venueID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(venue);
    }

    @DeleteMapping("delete/{venueID}")
    public ResponseEntity<Void> delete(@PathVariable String venueID){
        log.info("Delete request:{}", venueID);
        this.venueService.deleteById(venueID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Venue>> findAll(){
        List<Venue> venueList = this.venueService.findAll();
        return ResponseEntity.ok(venueList);
    }
}
