package com.allas.api_school.dto;

public class DataTeacher {

    private String name;
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
