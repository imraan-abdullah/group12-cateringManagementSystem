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
 * InventoryController.java
 * Controller for Inventory
 * Author: Thina Mzosindiso Nontwabaza (219189153)
 * Date: 19 August 2022
 */

@RestController
@RequestMapping("cateringManagementSystem/inventory/")
@Slf4j

public class InventoryController {
    private IInventoryService inventoryService;

    @Autowired
    public InventoryController(IInventoryService inventory){
        this.inventoryService = inventory;
    }

    @PostMapping("save")
    public ResponseEntity<Inventory> save(@Valid @RequestBody Inventory inventory){
        log.info("Save request:{}", inventory);
        Inventory inventory1;
        try{
            inventory1 = InventoryFactory.build(inventory.getItemID(), inventory.getItemDescription(), inventory.getItemQuantity(), inventory.getStockAvailability());
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Inventory save = inventoryService.save(inventory1);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{itemID}")
    public ResponseEntity<Inventory> read(@PathVariable String itemID){
        log.info("Read request:{}", itemID);
        Inventory inventory = this.inventoryService.read(itemID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(inventory);
    }

    @DeleteMapping("delete/{itemID}")
    public ResponseEntity<Void> delete(@PathVariable String itemID){
        log.info("Delete request:{}", itemID);
        this.inventoryService.deleteById(itemID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Inventory>> findAll(){
        List<Inventory> inventoryList = this.inventoryService.findAll();
        return ResponseEntity.ok(inventoryList);
    }
}
