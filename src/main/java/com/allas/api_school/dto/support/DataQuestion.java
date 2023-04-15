package com.allas.api_school.dto.support;

import com.allas.api_school.model.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DataQuestion {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Subject subject;

    public DataQuestion() {
    }

    public DataQuestion(String title, String description) {
        this.title = title;
        this.description = description;
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
}
