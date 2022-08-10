package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Chef;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.repository.IWaitingStaffRepository;
import za.ac.cput.service.IWaitingStaffService;

import java.util.List;
import java.util.Optional;

@Service
public class WaitingStaffServiceImpl implements IWaitingStaffService {
    private final IWaitingStaffRepository repository;

    @Autowired
    public WaitingStaffServiceImpl(IWaitingStaffRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public WaitingStaff save(WaitingStaff waitingStaff) {
        return this.repository.save(waitingStaff);
    }

    @Override
    public Optional<WaitingStaff> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(WaitingStaff waitingStaff) {
        this.repository.delete(waitingStaff);
    }

    @Override
    public List<WaitingStaff> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<WaitingStaff> waitingStaff = read(id);
        if(waitingStaff.isPresent())
            delete(waitingStaff.get());
    }
}
