package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;
import za.ac.cput.service.IManagerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/manager/")
@Slf4j

public class ManagerController {

    private final IManagerService service;

    @Autowired
    public ManagerController(IManagerService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Manager> safe(@Valid @RequestBody Manager manager){
        log.info("Save request:{}", manager);
        Manager newManager;
        try
        {
            newManager = ManagerFactory.createManager(manager.getEmployeeId(), manager.getFirstName(), manager.getLastName());
        }
        catch (IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Manager save = service.save(newManager);
        return  ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Manager> read(@PathVariable String id){
        log.info("Read request:{}", id);
        Manager manager = this.service.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(manager);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Manager>> findAll(){
        List <Manager> manager = this.service.findAll();
        return ResponseEntity.ok(manager);
    }
}
