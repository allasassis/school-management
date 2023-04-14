package com.allas.api_school.repository;

import com.allas.api_school.model.Student;
import com.allas.api_school.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Optional<Student>> findByName(String name);

    List<Optional<Student>> findByAddressZipCode(Integer zipcode);

    @Query("{ 'matriculated' :  true}")
    List<Student> findAllMatriculatedStudents();
}
