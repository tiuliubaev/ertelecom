package com.ertelecom.server.services;

import com.ertelecom.gwt.common.TaskDto;
import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.entities.Task;
import com.ertelecom.server.repositories.TaskRepository;
import com.ertelecom.server.repositories.TaskSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(String status, Employee executor) {
        Specification<Task> spec = Specification.where(null);
        if (status != null && !status.equals("")) {
            spec = spec.and(TaskSpecifications.findTaskByStatus(Task.Status.valueOf(status)));
        }
        if (executor != null && !executor.equals("")) {
            spec = spec.and(TaskSpecifications.findTaskByExecutor(executor));
        }
        return taskRepository.findAll(spec);
    }

    public Task getById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public TaskDto save(Task task) {
        taskRepository.save(task);
        return new TaskDto(task.getId(), task.getName(), task.getOwner().employeetoDto(), task.getExecutor().employeetoDto(), task.getDescription(), task.getStatus().getRusTitle());
    }

    @Secured("hasRole('ROLE_ADMIN')")
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public boolean existById(Long taskId) {
        return taskRepository.existsById(taskId);
    }
}
