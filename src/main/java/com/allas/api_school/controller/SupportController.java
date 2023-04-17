package com.allas.api_school.controller;

import com.allas.api_school.dto.support.DataListQuestions;
import com.allas.api_school.dto.support.DataQuestion;
import com.allas.api_school.exception.ApiException;
import com.allas.api_school.model.Question;
import com.allas.api_school.repository.QuestionRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/support")
@SecurityRequirement(name = "bearer-key")
public class SupportController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public ResponseEntity<List<DataListQuestions>> listQuestions() {
        List<DataListQuestions> questions = questionRepository.findAll().stream().map(DataListQuestions::new).toList();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/solved")
    public ResponseEntity<List<DataListQuestions>> listQuestionsSolved() {
        List<Optional<Question>> list = questionRepository.findAllSolved();

        List<DataListQuestions> listQuestions = verifierAndConversor(list);

        return ResponseEntity.ok(listQuestions);
    }

    @GetMapping("/notsolved")
    public ResponseEntity<List<DataListQuestions>> listQuestionsNotSolved() {
        List<Optional<Question>> list = questionRepository.findAllNotSolved();

        List<DataListQuestions> listQuestions = verifierAndConversor(list);

        return ResponseEntity.ok(listQuestions);
    }

    @PostMapping
    public ResponseEntity<DataQuestion> postQuestion(@RequestBody @Valid DataQuestion dataQuestion) {
        questionRepository.save(new Question(dataQuestion));
        return ResponseEntity.status(201).body(dataQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity markAsSolved(@PathVariable String id) {
        Optional<Question> question = questionRepository.findById(id);

        if (question.isEmpty()) {
            throw new ApiException("This ID does not exist in our database!");
        }

        Question question1 = question.get();
        question1.markAsSolved();
        questionRepository.save(question1);
        return ResponseEntity.noContent().build();
    }

    private List<DataListQuestions> verifierAndConversor(List<Optional<Question>> list) {
        if (list.isEmpty()) {
            throw new ApiException("There is no solved questions in our database.");
        }

        List<Question> list1 = new ArrayList<Question>();

        list.forEach(question -> list1.add(question.get()));
        List<DataListQuestions> questionList = list1.stream().map(DataListQuestions::new).toList();

        return questionList;
    }

}
