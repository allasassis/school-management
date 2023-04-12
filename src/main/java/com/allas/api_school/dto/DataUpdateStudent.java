package com.allas.api_school.dto;

import com.allas.api_school.model.Address;

import java.time.LocalDate;

public class DataUpdateStudent {

    private String name;

    private DataUpdateAddress address;

    private LocalDate birthdate;

    public DataUpdateStudent() {
    }

    public DataUpdateStudent(String name, DataUpdateAddress address, LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public DataUpdateAddress getAddress() {
        return address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
