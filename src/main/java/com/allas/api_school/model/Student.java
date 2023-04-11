package com.allas.api_school.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("students")
public class Student {

    @Id
    private String id;

    private String name;

    private Address address;
    private LocalDate birthdate;

    public Student() {
    }

    public Student(String id, String name, Address address, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
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
