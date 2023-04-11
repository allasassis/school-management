package com.allas.api_school.model;

import com.allas.api_school.dto.DataTeacher;
import com.allas.api_school.dto.DataUpdateTeacher;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("teachers")
public class Teacher {

    @Id
    private String id;

    private String name;
    private String subject;

    public Teacher() {
    }

    public Teacher(String id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public Teacher(DataTeacher dataTeacher) {
        this.name = dataTeacher.getName();
        this.subject = dataTeacher.getSubject();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void update(DataUpdateTeacher dataUpdateTeacher) {
        if (dataUpdateTeacher.getName() != null) {
            this.name = dataUpdateTeacher.getName();
        }
        if (dataUpdateTeacher.getSubject() != null) {
            this.subject = dataUpdateTeacher.getSubject();
        }
    }
}
