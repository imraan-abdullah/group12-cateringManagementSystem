package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.service.IPaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cateringManagementSystem/payment/")
@Slf4j

public class PaymentController {

    private final IPaymentService service;

    @Autowired
    public PaymentController(IPaymentService service) {this.service = service;}

    @PostMapping("save")
    public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment) {
        log.info("Save request:{}", payment);
        Payment newPayment;
        try {
            newPayment = PaymentFactory.build(payment.getPaymentNum(),payment.getClientNum(), payment.getAmount(), payment.getPaymentType(), payment.getDate(), payment.getVenueId());
        }
        catch(IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Payment save = service.save(newPayment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Payment> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Payment payment = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Payment>> findAll() {
        List <Payment> date = this.service.findAll();
        return ResponseEntity.ok(date);
    }
}
