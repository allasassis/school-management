package com.allas.api_school.dto.teacher;

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

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

}
