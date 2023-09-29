package com.crud.demo.Entity;

import jakarta.persistence.Column;

public class EmployeeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int dept_id;

    public EmployeeDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public EmployeeDTO(String firstName, String lastName, String email, int dept_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept_id = dept_id;
    }

    public EmployeeDTO(int id, String firstName, String lastName, String email, int dept_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept_id = dept_id;
    }

    public EmployeeDTO(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public EmployeeDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}
