package com.allas.api_school.model;

import com.allas.api_school.dto.support.DataQuestion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("questions")
public class Question {

    @Id
    private String id;

    private String title;
    private String description;
    private Subject subject;
    private boolean isSolved = false;


    public Question() {
    }

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Question(DataQuestion dataQuestion) {
        this.title = dataQuestion.getTitle();
        this.description = dataQuestion.getDescription();
        this.subject = dataQuestion.getSubject();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Subject getSubject() {
        return subject;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void markAsSolved() {
        this.isSolved = true;
    }
}
