package com.allas.api_school.controller;

import com.allas.api_school.dto.DataListStudent;
import com.allas.api_school.model.Student;
import com.allas.api_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
