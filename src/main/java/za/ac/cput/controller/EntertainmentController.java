package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.factory.EntertainmentFactory;
import za.ac.cput.service.IEntertainmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/entertainment/")
@Slf4j

public class EntertainmentController
{
    private final IEntertainmentService service;

    @Autowired
    public EntertainmentController(IEntertainmentService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Entertainment> safe(@Valid @RequestBody Entertainment entertainment)
    {
        log.info("Save request:{}", entertainment);
        Entertainment newEntertainment;
        try
        {
            newEntertainment = EntertainmentFactory.build(entertainment.getEntertainmentType(), entertainment.getCost());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Entertainment save = service.save(newEntertainment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Entertainment> read(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        Entertainment entertainment = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(entertainment);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Entertainment>> findAll()
    {
        List <Entertainment> entertainment = this.service.findAll();
        return ResponseEntity.ok(entertainment);
    }
}
