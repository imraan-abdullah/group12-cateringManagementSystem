package za.ac.cput.service;

import za.ac.cput.entity.Date;

import java.util.List;

public interface IDateService extends IService <Date, String> {
    List<Date> findAll();
    void deleteById (String id);
}
