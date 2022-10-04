package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.service.IStaffService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/staff/")
@Slf4j

public class StaffController {

    private final IStaffService service;

    @Autowired
    public StaffController(IStaffService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Staff> safe(@Valid @RequestBody Staff staff){
        log.info("Save request:{}", staff);
        Staff newStaff;
        try
        {
            newStaff = StaffFactory.createStaff(staff.getEmployeeId(), staff.getFirstName(), staff.getLastName(), staff.getStaffType());
        }
        catch (IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Staff save = service.save(newStaff);
        return  ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Staff> read(@PathVariable String id){
        log.info("Read request:{}", id);
        Staff staff = this.service.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(staff);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Staff>> findAll(){
        List <Staff> staff = this.service.findAll();
        return ResponseEntity.ok(staff);
    }
}

