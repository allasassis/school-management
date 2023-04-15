package com.allas.api_school.dto.support;

import com.allas.api_school.model.Question;
import com.allas.api_school.model.Subject;

public class DataListQuestions {

    private String title;
    private Subject subject;

    public DataListQuestions() {
    }

    public DataListQuestions(Question question) {
        this.title = question.getTitle();
        this.subject = question.getSubject();
    }

    public DataListQuestions(String title, Subject subject) {
        this.title = title;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public Subject getSubject() {
        return subject;
    }
}
