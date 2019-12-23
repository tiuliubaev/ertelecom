package com.ertelecom.server.controllers;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.TaskDto;
import com.ertelecom.server.entities.Employee;
import com.ertelecom.server.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> showHomePage(Model model, @RequestParam(value = "last_name", required = false) String last_name, @RequestParam(value = "fst_name", required = false) String fst_name, @RequestParam(value = "id", required = false) Long id, Principal principal) {
//        Employee employee = employeeService.findOneByUserName(principal.getName());
//        StringBuilder info = new StringBuilder();
//        info.append("Id: ").append(employee.getId()).append("\n");
//        info.append("UserName").append(employee.getUsername()).append("\n");
//        info.append("Roles").append(employee.getRoles());
//        model.addAttribute("userinfo", info.toString());
        List<EmployeeDto> employees = employeeService.getAllEmployees(last_name, fst_name).stream().map(employee -> employee.employeetoDto()).collect(Collectors.toList());
        return employees;
    }
}
