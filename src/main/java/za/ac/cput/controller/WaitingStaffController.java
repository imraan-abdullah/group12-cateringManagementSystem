package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.factory.WaitingStaffFactory;
import za.ac.cput.service.IWaitingStaffService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/waitingStaff/")
@Slf4j

public class WaitingStaffController
{
    private final IWaitingStaffService service;

    @Autowired
    public WaitingStaffController(IWaitingStaffService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<WaitingStaff> safe(@Valid @RequestBody WaitingStaff waitingStaff)
    {
        log.info("Save request:{}", waitingStaff);
        WaitingStaff newWaitingStaff;
        try
        {
            newWaitingStaff = WaitingStaffFactory.build(waitingStaff.getEmployeeId(), waitingStaff.getFirstName(), waitingStaff.getLastName());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        WaitingStaff save = service.save(newWaitingStaff);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<WaitingStaff> read(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        WaitingStaff waitingStaff = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(waitingStaff);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<WaitingStaff>> findAll()
    {
        List <WaitingStaff> waitingStaff = this.service.findAll();
        return ResponseEntity.ok(waitingStaff);
    }
}
