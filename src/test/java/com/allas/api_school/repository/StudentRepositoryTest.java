package com.allas.api_school.repository;

import com.allas.api_school.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAllMatriculatedStudents() {
        List<Student> list = studentRepository.findAllMatriculatedStudents();

        for (int i = 0; i < list.size(); i++) {
            Assertions.assertThat(list.get(i).isMatriculate()).isTrue();
        }
    }
}