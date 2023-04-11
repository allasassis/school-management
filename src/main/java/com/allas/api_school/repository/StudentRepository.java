package com.allas.api_school.repository;

import com.allas.api_school.model.Student;
import com.allas.api_school.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
