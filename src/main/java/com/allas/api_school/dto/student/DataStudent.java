package com.allas.api_school.dto.student;

import com.allas.api_school.model.Address;
import com.allas.api_school.model.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DataStudent {

    @NotBlank
    private String name;

    @NotNull
    @Valid
    private Address address;
    @NotNull
    private LocalDate birthdate;

    public DataStudent() {
    }

    public DataStudent(String name, Address address, LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }

    public DataStudent(Student student) {
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
