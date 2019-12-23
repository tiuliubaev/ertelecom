package com.ertelecom.server.repositories;

import com.ertelecom.gwt.common.TaskDto;
import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.entities.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> findTaskByStatus(Task.Status status) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Task> findTaskByExecutor(Employee executor) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("executor"), executor);
    }

    //    public static Specification<Task> findTaskByExecutor(String executor) {
    //        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("executor")),"%" + executor.toLowerCase() + "%");
    //    }
}
