package com.allas.api_school.dto.teacher;

import com.allas.api_school.model.Teacher;

public class DataDetailTeacher {

    private String name;
    private String subject;

    public DataDetailTeacher() {
    }

    public DataDetailTeacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public DataDetailTeacher(Teacher teacher) {
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
