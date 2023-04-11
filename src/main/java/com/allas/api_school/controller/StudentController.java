package com.allas.api_school.controller;

import com.allas.api_school.dto.DataListStudent;
import com.allas.api_school.dto.DataStudent;
import com.allas.api_school.model.Student;
import com.allas.api_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
