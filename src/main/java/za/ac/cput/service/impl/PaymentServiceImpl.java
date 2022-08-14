package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.IPaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository repository;

    @Autowired public PaymentServiceImpl(IPaymentRepository repository) { this.repository = repository; }
    @Override
    public Payment save (Payment payment) { return this.repository.save(payment); }

    @Override
    public Optional<Payment>read(String paymentNum) { return this.repository.findById(paymentNum); }

    @Override
    public void delete (Payment payment) {
        this.repository.delete(payment);
    }

    @Override
    public List<Payment> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Payment> payment = read(id);
        if(payment.isPresent())
            delete(payment.get());
    }
}
