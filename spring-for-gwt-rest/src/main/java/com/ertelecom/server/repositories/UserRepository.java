package com.ertelecom.server.repositories;

import com.ertelecom.server.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Employee, Long> {
    Employee findOneByUsername(String username);
}
