package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.service.IClientService;

import javax.validation.Valid;
import java.util.List;

//Mariam Gallie- 219094837
// ClientController.java (controller package)
// 9 October 2022

@RestController
@RequestMapping("cateringManagementSystem/client/")
@Slf4j
public class ClientController {
    private final IClientService iClientService;

    @Autowired
    public ClientController(IClientService iClientService){
        this.iClientService = iClientService;
    }
    @PostMapping("save")
    public ResponseEntity<Client> save(@Valid @RequestBody Client client){
        log.info("save request:{}",client);
        Client valClient;
        try {
            valClient = ClientFactory.build(client.getClientNum(), client.getFirstName(), client.getLastName()
                    , client.getEmail(),client.getPhoneNum());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Client save = iClientService.save(valClient);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Client> read(@PathVariable String id){
        log.info("Read request:{}",id);
        Client client = this.iClientService.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(client);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.iClientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Client>>findAll() {
        List<Client> client = this.iClientService.findAll();
        return ResponseEntity.ok(client);
    }


}
