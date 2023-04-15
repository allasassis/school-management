package com.allas.api_school.dto.teacher;

public class DataUpdateTeacher {

    private String name;
    private String subject;

    public DataUpdateTeacher() {
    }

    public DataUpdateTeacher(String name) {
        this.name = name;
    }

    public DataUpdateTeacher(String name, String subject) {
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
