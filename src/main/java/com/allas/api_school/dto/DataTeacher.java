package com.allas.api_school.dto;

import com.allas.api_school.model.Teacher;
import jakarta.validation.constraints.NotBlank;

public class DataTeacher {

    @NotBlank
    private String name;

    @NotBlank
    private String subject;

    public DataTeacher() {
    }

    public DataTeacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public DataTeacher(Teacher teacher) {
        this.name = teacher.getName();
        this.subject = teacher.getSubject();
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
}
