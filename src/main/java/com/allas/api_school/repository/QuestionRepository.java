package com.allas.api_school.repository;

import com.allas.api_school.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends MongoRepository<Question, String> {

    @Query("{ isSolved : true}")
    List<Optional<Question>> findAllSolved();

    @Query("{ isSolved : false}")
    List<Optional<Question>> findAllNotSolved();
}
