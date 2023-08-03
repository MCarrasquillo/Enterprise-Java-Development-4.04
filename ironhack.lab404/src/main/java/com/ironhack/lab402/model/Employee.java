package com.ironhack.lab402.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    private Integer id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Employee() {
    }

    public Employee(Integer id, String department, String name, Status status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
