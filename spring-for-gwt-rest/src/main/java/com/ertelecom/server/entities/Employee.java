package com.ertelecom.server.entities;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "employee")
@Data
//@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee_id")
    @SequenceGenerator(name = "seq_employee_id", sequenceName = "s_employee_id", allocationSize = 1)
    @Column(name = "ROW_ID")
    Long id;
    @Column(name = "LAST_NAME")
    String last_name;
    @Column(name = "FST_NAME")
    String fst_name;
    @Column(name = "MID_NAME")
    String mid_name;
    @Column(name = "JOB_TITLE")
    String job_title;
    @Column(name = "WORK_PH_NUM")
    String work_ph_num;


    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Collection<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    public Employee() {
    }


    public Employee(Long id, String last_name, String fst_name, String mid_name, String job_title, String work_ph_num) {
        this.id = id;
        this.last_name = last_name;
        this.fst_name = fst_name;
        this.mid_name = mid_name;
        this.job_title = job_title;
        this.work_ph_num = work_ph_num;
    }

    public String getLast_name() {
        return last_name;
    }

    public EmployeeDto employeetoDto() {
        return new EmployeeDto(
                this.id,
                this.last_name,
                this.fst_name,
                this.mid_name,
                this.job_title,
                this.work_ph_num
        );
    }

    public Employee(EmployeeDto employeeDto){
        this.id = employeeDto.getId();
                this.last_name = employeeDto.getLast_name();
                this.fst_name = employeeDto.getFst_name();
                this.mid_name = employeeDto.getMid_name();
                this.job_title = employeeDto.getJob_title();
                this.work_ph_num = employeeDto.getWork_ph_num();
    }

    @Override
    public String toString() {
        return "id " + id + ". last_name: " + last_name + ". fst_name: " + fst_name + ".";
    }
}
