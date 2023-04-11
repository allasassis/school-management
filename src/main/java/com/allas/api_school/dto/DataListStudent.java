package com.allas.api_school.dto;

import com.allas.api_school.model.Address;
import com.allas.api_school.model.Student;

import java.time.LocalDate;

public class DataListStudent {

    private String name;
    private Address address;
    private LocalDate birthdate;

    public DataListStudent() {
    }

    public DataListStudent(String name, Address address, LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }

    public DataListStudent(Student student) {
        this.name = student.getName();
        this.address = student.getAddress();
        this.birthdate = student.getBirthdate();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
