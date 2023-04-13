package com.allas.api_school.utils;

import com.allas.api_school.dto.DataStudentListDetails;
import com.allas.api_school.exception.ApiException;
import com.allas.api_school.model.Student;
import com.allas.api_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentUtils {

    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()) {
            throw new ApiException("This ID does not exist in our database!");
        }

        return student.get();
    }

    public void verifyIfIsEmpty(List<Optional<Student>> studentList) {
        if (studentList.isEmpty()) {
            throw new ApiException("Student is null!");
        }
    }

    public List<DataStudentListDetails> listConversorStudents(List<Optional<Student>> studentList) {
        List<Student> list = new ArrayList<>();

        for (Optional<Student> student1 : studentList) {
            list.add(student1.get());
        }

        return list.stream().map(DataStudentListDetails::new).toList();
    }
}
