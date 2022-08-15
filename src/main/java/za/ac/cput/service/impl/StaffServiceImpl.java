package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Staff;
import za.ac.cput.repository.IStaffRepository;
import za.ac.cput.service.IStaffService;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements IStaffService{

    private final IStaffRepository repository;

    @Autowired
    public StaffServiceImpl(IStaffRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Staff save(Staff staff) {
        return this.repository.save(staff);
    }

    @Override
    public Optional<Staff> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Staff staff) {
        this.repository.delete(staff);
    }

    @Override
    public List<Staff> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Staff> staff = read(id);
        if(staff.isPresent())
            delete(staff.get());
    }

}
