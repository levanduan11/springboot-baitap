package com.jobhunt.service.Impl;

import com.jobhunt.domain.Employer;
import com.jobhunt.repository.BaseRepositoty;
import com.jobhunt.service.IEmployerService;
import com.jobhunt.service.error.EmployerNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployerService implements IEmployerService {
    private final BaseRepositoty<Employer, String> employerRepo;

    public EmployerService(@Qualifier("employerRepository") BaseRepositoty baseRepositoty) {
        this.employerRepo = baseRepositoty;
    }

    @Override
    public List<Employer> listAll() {
        return employerRepo.findAll();
    }

    @Override
    public Employer save(Employer employer) {
        String id = employer.getId();
        if (id == null || id.equals("")) {
            id = UUID.randomUUID().toString();
            employer.setId(id);
        }
        return employerRepo.save(employer);
    }

    @Override
    public Employer getById(String id) throws EmployerNotFoundException {
        return employerRepo.findById(id).orElseThrow(() -> new EmployerNotFoundException("not found id: " + id));
    }

    @Override
    public void deleteEmployer(String id) {
        employerRepo.delete(id);
    }
}
