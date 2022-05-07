package com.jobhunt.service;

import com.jobhunt.domain.Employer;
import com.jobhunt.service.error.EmployerNotFoundException;

import java.util.List;

public interface IEmployerService {
    List<Employer>listAll();
    Employer save(Employer employer);
    Employer getById(String id) throws EmployerNotFoundException;
    void deleteEmployer(String id);
}
