package com.allas.api_school.controller;

import com.allas.api_school.dto.DataListStudent;
import com.allas.api_school.dto.DataStudent;
import com.allas.api_school.exception.ApiException;
import com.allas.api_school.model.Student;
import com.allas.api_school.model.Teacher;
import com.allas.api_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<DataListStudent>> listStudents() {
        List<DataListStudent> list = studentRepository.findAll().stream().map(DataListStudent::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<DataStudent> insertStudent(@RequestBody DataStudent dataStudent) {
        Student student = new Student(dataStudent);
        studentRepository.save(student);
        return ResponseEntity.status(201).body(new DataStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        Student student = findStudent(id);
        studentRepository.delete(student);
        return ResponseEntity.noContent().build();
    }

    private Student findStudent(String id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()) {
            throw new ApiException("This ID does not exist in our database!");
        }

        return student.get();
    }
}
