package com.ertelecom.server.repositories;

import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.entities.Task;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications {
    public static Specification<Employee> getAllExecutors() {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), "Executor");
    }
    public static Specification<Employee> getAllOwners() {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), "Owner");
    }

    public static Specification<Employee> findEmployeeByLast_name(String last_name) {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("last_name"), last_name);
    }

    public static Specification<Employee> findEmployeeByFst_name(String fst_name) {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("fst_name"), fst_name);
    }

    public static Specification<Employee> getAllEmployees(String job_title) {
        return (Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("job_title"), job_title);
    }
}
