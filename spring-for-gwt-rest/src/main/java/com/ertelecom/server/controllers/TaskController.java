package com.ertelecom.server.controllers;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.StatusDto;
import com.ertelecom.gwt.common.TaskDto;
import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.entities.Task;
import com.ertelecom.server.services.EmployeeService;
import com.ertelecom.server.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin

public class TaskController {
    private TaskService taskService;
    private EmployeeService employeeService;
//    private UserDetailsService userDetailsService;

    @Autowired
    public TaskController(TaskService taskServiceJPA, EmployeeService employeeServiceJPA) {
        this.taskService = taskServiceJPA;
        this.employeeService = employeeServiceJPA;
//        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> showHomePage(Model model, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "executor", required = false) Employee executor, @RequestParam(value = "id", required = false) Long id, Principal principal) {
        Employee employee = employeeService.findOneByUserName(principal.getName());
        StringBuilder info = new StringBuilder();
        info.append("Id: ").append(employee.getId()).append("\n");
        info.append("UserName").append(employee.getUsername()).append("\n");
        info.append("Roles").append(employee.getRoles());
        model.addAttribute("userinfo", info.toString());
        List<TaskDto> tasks = taskService.getAll(status, executor).stream().map(task -> task.tasktoDto()).collect(Collectors.toList());
        return tasks;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto addTaskProcessForm(@RequestBody TaskDto taskDto) {
        Task task = new Task(taskDto.getId(), taskDto.getName(), new Employee(taskDto.getOwner()), new Employee(taskDto.getExecutor()), taskDto.getDescription(), Task.Status.valueOf(taskDto.getStatus()));
        return taskService.save(task);
    }

    @GetMapping("/tasks/delete/{id}")
    @RequestMapping(path = "/tasks/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> removeTask(Model model, @PathVariable(name = "id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<String>("Successfully removed", HttpStatus.OK);
    }

//    @GetMapping("/employees")
//    public String EmployeesList(Model model, @RequestParam(value = "job_title", required = false) String job_title) {
//        model.addAttribute("employees", employeeService.getAllEmployees(job_title));
//        return "employees_list";
//    }

    @GetMapping("/tasks/executors")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> exucutorsList(Model model, @RequestParam(value = "job_title", required = false) String job_title) {
        ArrayList list = new ArrayList(employeeService.getAllExecutors());
        return list;
    }

    @GetMapping("/tasks/owners")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> ownersList(Model model, @RequestParam(value = "job_title", required = false) String job_title) {
        ArrayList list = new ArrayList(employeeService.getAllOwners());
        return list;
    }

    @GetMapping("/tasks/taskStatus")
    @ResponseStatus(HttpStatus.OK)
    public List<StatusDto> getAllItems() {
        List<StatusDto> list = new ArrayList<>();
        for (int ind = 0; ind < Task.Status.values().length; ind++) {
            list.add(new StatusDto(ind, Task.Status.values()[ind].toString()));
        }
        return list;
    }

    @RequestMapping(path = "/task/id={id}", method = RequestMethod.GET)
    public String taskForm(Model model, @PathVariable Long id) {
        model.addAttribute("task", taskService.getById(id));
        return "task_form";
    }

//    @DeleteMapping("/tasks/{id}")
//    public ResponseEntity<String> deleteTask(@PathVariable(name = "id") Long id) {
//        taskService.delete(id);
//        return new ResponseEntity<String>("Successfully removed", HttpStatus.OK);
//    }
}
