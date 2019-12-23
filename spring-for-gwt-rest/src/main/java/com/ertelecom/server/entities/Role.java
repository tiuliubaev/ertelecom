package com.ertelecom.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
//@Data
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role_id")
//    @SequenceGenerator(name = "seq_role_id", sequenceName = "s_role_id", allocationSize = 1)
    @Column(name = "ROW_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Role() {
    }

    @Override
    public String toString() {
        return name;
    }
}
