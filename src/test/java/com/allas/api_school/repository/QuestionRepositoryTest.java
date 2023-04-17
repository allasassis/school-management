package com.allas.api_school.repository;

import com.allas.api_school.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void findAllSolved() {
        List<Optional<Question>> list = questionRepository.findAllSolved();
        List<Question> questionList = new ArrayList<>();

        for (Optional<Question> question: list) {
            questionList.add(question.get());
        }

        for (int i = 0; i < questionList.size(); i++) {
            Assertions.assertThat(questionList.get(i).isSolved()).isTrue();
        }
    }

    @Test
    void findAllNotSolved() {
        List<Optional<Question>> list = questionRepository.findAllNotSolved();
        List<Question> questionList = new ArrayList<>();

        for (Optional<Question> question: list) {
            questionList.add(question.get());
        }

        for (int i = 0; i < questionList.size(); i++) {
            Assertions.assertThat(questionList.get(i).isSolved()).isFalse();
        }
    }
}