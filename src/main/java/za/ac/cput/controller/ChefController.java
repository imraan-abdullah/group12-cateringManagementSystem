package za.ac.cput.controller;

/*
 * ChefController.java Controller for Chef
 * Author: Imraan Abdullah
 * 219361738
 * Date: 18 August 2022
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Chef;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.service.IChefService;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("cateringManagementSystem/chef/")
@Slf4j

public class ChefController
{
    private final IChefService service;

    @Autowired
    public ChefController(IChefService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Chef> safe(@Valid @RequestBody Chef chef)
    {
        log.info("Save request:{}", chef);
        Chef newChef;
        try
        {
            newChef = ChefFactory.build(chef.getEmployeeId(), chef.getFirstName(), chef.getLastName());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Chef save = service.save(newChef);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Chef> read(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        Chef chef = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(chef);
    }

    @DeleteMapping("delete/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Chef>> findAll()
    {
        List <Chef> chef = this.service.findAll();
        return ResponseEntity.ok(chef);
    }
}
