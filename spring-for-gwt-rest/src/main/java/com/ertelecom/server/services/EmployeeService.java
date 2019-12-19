package com.ertelecom.server.services;

import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.repositories.EmployeeRepository;
import com.ertelecom.server.repositories.EmployeeSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllExecutors() {
        Specification<Employee> spec = Specification.where(null);
        spec = spec.and(EmployeeSpecifications.getAllExecutors());
        return employeeRepository.findAll(spec);
    }
    public List<Employee> getAllOwners() {
        Specification<Employee> spec = Specification.where(null);
        spec = spec.and(EmployeeSpecifications.getAllOwners());
        return employeeRepository.findAll(spec);
    }

    public List<Employee> getAllEmployees(String job_title) {
        Specification<Employee> spec = Specification.where(null);
        if (job_title != null && !job_title.equals("")) {
            spec = spec.and(EmployeeSpecifications.getAllEmployees(job_title));
        }
        return employeeRepository.findAll(spec);
    }
}
