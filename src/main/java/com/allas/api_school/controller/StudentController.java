package com.allas.api_school.controller;

import com.allas.api_school.dto.DataListStudent;
import com.allas.api_school.dto.DataStudent;
import com.allas.api_school.dto.DataStudentListDetails;
import com.allas.api_school.dto.DataUpdateStudent;
import com.allas.api_school.model.Student;
import com.allas.api_school.repository.StudentRepository;
import com.allas.api_school.utils.StudentUtils;
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

    @Autowired
    private StudentUtils studentUtils;

    @GetMapping
    public ResponseEntity<List<DataListStudent>> listStudents() {
        List<DataListStudent> list = studentRepository.findAll().stream().map(DataListStudent::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{name}")
    public ResponseEntity findStudentByName(@PathVariable String name) {
        List<Optional<Student>> studentList = studentRepository.findByName(name);

        studentUtils.verifyIfIsEmpty(studentList);

        if (studentList.size() > 1) {
            List<DataStudentListDetails> listStudents = studentUtils.listConversorStudents(studentList);
            return ResponseEntity.ok(listStudents);
        }

        return ResponseEntity.ok(new DataStudent(studentList.get(0).get()));
    }

    @GetMapping("/address/{zipcode}")
    public ResponseEntity findStudentByZipCode(@PathVariable Integer zipcode) {
        List<Optional<Student>> studentList = studentRepository.findByAddressZipCode(zipcode);
        studentUtils.verifyIfIsEmpty(studentList);

        if (studentList.size() > 1) {
            List<DataStudentListDetails> listStudents = studentUtils.listConversorStudents(studentList);
            return ResponseEntity.ok(listStudents);
        }

        return ResponseEntity.ok(new DataStudent(studentList.get(0).get()));

    }

    @PostMapping
    public ResponseEntity<DataStudent> insertStudent(@RequestBody DataStudent dataStudent) {
        Student student = new Student(dataStudent);
        studentRepository.save(student);
        return ResponseEntity.status(201).body(new DataStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataStudent> updateStudent(@PathVariable String id, @RequestBody DataUpdateStudent dataUpdateStudent) {
        Student student = studentUtils.findStudentById(id);
        student.update(dataUpdateStudent);
        studentRepository.save(student);

        return ResponseEntity.ok(new DataStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        Student student = studentUtils.findStudentById(id);
        studentRepository.delete(student);
        return ResponseEntity.noContent().build();
    }


}
