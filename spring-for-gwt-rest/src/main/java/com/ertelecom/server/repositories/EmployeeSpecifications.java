package com.ertelecom.server.repositories;

import com.ertelecom.server.entities.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications {
    public static Specification<Employee> getAllExecutors() {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), "Executor");
    }
    public static Specification<Employee> getAllOwners() {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), "Owner");
    }
    public static Specification<Employee> getAllEmployees(String job_title) {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), job_title);
    }
}
