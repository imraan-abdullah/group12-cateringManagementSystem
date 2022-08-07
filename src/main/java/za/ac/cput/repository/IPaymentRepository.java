package za.ac.cput.repository;

/*
 * IPaymentRepository.java repository interface
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import za.ac.cput.entity.Payment;

import java.util.Set;

public interface IPaymentRepository extends IRepository<Payment, String>{
    public Set<Payment> getAll();
}
