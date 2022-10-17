/*
AdminController.java
Author: Ameer Samsodien (220005060)
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.IAdminService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/admin/")
@Slf4j

public class AdminController {

    private final IAdminService service;

    @Autowired
    public AdminController(IAdminService service) {this.service = service;}

    @PostMapping("save")
    public ResponseEntity<Admin> safe(@Valid @RequestBody Admin admin)
    {
        log.info("save request:{}", admin);
        Admin newAdmin;
        try
        {
            newAdmin = AdminFactory.createAdmin(admin.getAdminNum(),admin.getFirstName(), admin.getLastName(), admin.getEmail(), admin.getPhoneNum());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Admin save = service.save(newAdmin);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Admin> read(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        Admin admin = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Admin>> findAll()
    {
        List <Admin> admin = this.service.findAll();
        return ResponseEntity.ok(admin);
    }
}
