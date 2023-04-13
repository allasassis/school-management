package com.allas.api_school.dto;

import com.allas.api_school.model.Address;
import com.allas.api_school.model.Student;

import java.time.LocalDate;

public class DataStudentListDetails {

    private String name;
    private Address address;
    private LocalDate birthdate;

    public DataStudentListDetails() {
    }

    public DataStudentListDetails(String name, Address address ,LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }

    public DataStudentListDetails(Student student) {
        this.name = student.getName();
        this.address = student.getAddress();
        this.birthdate = student.getBirthdate();
    }

    public String getName() {
        return name;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }
}
