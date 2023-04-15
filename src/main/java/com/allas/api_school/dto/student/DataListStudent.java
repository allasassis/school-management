package com.allas.api_school.dto.student;

import com.allas.api_school.model.Student;

import java.time.LocalDate;
import java.util.Optional;

public class DataListStudent {

    private String name;
    private LocalDate birthdate;

    public DataListStudent() {
    }

    public DataListStudent(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public DataListStudent(Student student) {
        this.name = student.getName();
        this.birthdate = student.getBirthdate();
    }

    public String getName() {
        return name;
    }


    public LocalDate getBirthdate() {
        return birthdate;
    }
}
