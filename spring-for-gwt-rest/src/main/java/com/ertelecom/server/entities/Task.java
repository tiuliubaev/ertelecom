package com.ertelecom.server.entities;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
public class Task implements Serializable {

    public enum Status {
        NEW("Новая"),
        IN_WORK("В работе"),
        COMPLETE("Выполнена");

        private String rusTitle;

        public String getRusTitle() {
            return rusTitle;
        }

        Status(String rusTitle) {
            this.rusTitle = rusTitle;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_task_id")
    @SequenceGenerator(name = "seq_task_id", sequenceName = "s_task_id", allocationSize = 1)
    @Column(name = "ROW_ID")
    public Long id;

    @Column(name = "NAME")
    @Size(min = 5, message = "Name must be at least 5 characters")
    String name;

    @OneToOne
    @JoinColumn(name="OWNER")
    private Employee owner;

    @OneToOne
    @JoinColumn(name="EXECUTOR")
    private Employee executor;

    @Column(name = "DESC_TEXT")
    String description;

    @Column(name = "STATUS")
    @Enumerated(javax.persistence.EnumType.STRING)
    Status status;

    public Task(Long id, String name, Employee owner, Employee executor, String description, Status status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
        this.status = status;
    }

    public TaskDto tasktoDto () {
        return new TaskDto(
            this.id,
            this.name,
            this.owner.employeetoDto(),
            this.executor.employeetoDto(),
            this.description,
                this.status.toString()
        );
    }

//    @Override
//    public String toString() {
//        return "id " + id + ". Name: " + name + ". Status: " + status + ".";
//    }

}
