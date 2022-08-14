package za.ac.cput.service;

import za.ac.cput.entity.Date;
import za.ac.cput.entity.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment, String> {
    List<Payment> findAll();
    void deleteById(String id);
}
