package com.allas.api_school.controller;

import com.allas.api_school.dto.DataTeacher;
import com.allas.api_school.exception.ApiException;
import com.allas.api_school.model.Teacher;
import com.allas.api_school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public ResponseEntity<List<Teacher>> listTeachers() {
        List<Teacher> list = teacherRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Teacher> insertTeacher(@RequestBody DataTeacher dataTeacher) {
        Teacher teacher = new Teacher(dataTeacher);
        teacherRepository.save(teacher);
        return ResponseEntity.status(201).body(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        if (teacher.isEmpty()) {
            throw new ApiException("This ID does not exist in our database!");
        }

        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
