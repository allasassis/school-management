package com.allas.api_school.controller;

import com.allas.api_school.dto.teacher.DataDetailTeacher;
import com.allas.api_school.dto.teacher.DataTeacher;
import com.allas.api_school.dto.teacher.DataUpdateTeacher;
import com.allas.api_school.exception.ApiException;
import com.allas.api_school.model.Teacher;
import com.allas.api_school.repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public ResponseEntity<List<DataDetailTeacher>> listTeachers() {
        List<DataDetailTeacher> list = teacherRepository.findAll().stream().map(DataDetailTeacher::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<DataDetailTeacher> insertTeacher(@RequestBody @Valid DataTeacher dataTeacher) {
        Teacher teacher = new Teacher(dataTeacher);
        teacherRepository.save(teacher);
        return ResponseEntity.status(201).body(new DataDetailTeacher(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataDetailTeacher> updateTeacher(@RequestBody DataUpdateTeacher dataUpdateTeacher, @PathVariable String id) {
        Teacher teacher = findTeacher(id);

        teacher.update(dataUpdateTeacher);
        teacherRepository.save(teacher);

        return ResponseEntity.ok(new DataDetailTeacher(teacher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id) {
        Teacher teacher = findTeacher(id);

        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private Teacher findTeacher(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        if (teacher.isEmpty()) {
            throw new ApiException("This ID does not exist in our database!");
        }

        return teacher.get();
    }
}
