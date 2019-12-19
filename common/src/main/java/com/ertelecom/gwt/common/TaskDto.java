package com.ertelecom.gwt.common;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class TaskDto implements Serializable {

    public Long id;
    String name;

    @JoinColumn(name = "OWNER")
    EmployeeDto owner;

    @JoinColumn(name = "EXECUTOR")
    EmployeeDto executor;

    String description;

    String status;


    public TaskDto(Long id, String name, EmployeeDto owner, EmployeeDto executor, String description, String status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
        this.status = status;
    }

    public TaskDto() {
    }

    public TaskDto(Long id, String name, String description) {

    }

    public TaskDto(String name, EmployeeDto owner, EmployeeDto executor, String description, String status) {
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeDto getOwner() {
        return owner;
    }

    public EmployeeDto getExecutor() {
        return executor;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(EmployeeDto owner) {
        this.owner = owner;
    }

    public void setExecutor(EmployeeDto executor) {
        this.executor = executor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
