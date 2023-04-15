package com.allas.api_school.controller;

import com.allas.api_school.dto.support.DataListQuestions;
import com.allas.api_school.dto.support.DataQuestion;
import com.allas.api_school.model.Question;
import com.allas.api_school.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public ResponseEntity<List<DataListQuestions>> listQuestions() {
        List<DataListQuestions> questions = questionRepository.findAll().stream().map(DataListQuestions::new).toList();
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<DataQuestion> postQuestion(@RequestBody DataQuestion dataQuestion) {
        questionRepository.save(new Question(dataQuestion));
        return ResponseEntity.status(201).body(dataQuestion);
    }

}
