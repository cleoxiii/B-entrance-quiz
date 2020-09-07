package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    public static List<Student> studentList;

    private void initStudentList() {
        studentList = new ArrayList<>();
        studentList.add(new Student("贠晨曦"));
    }


    @GetMapping("/student-list")
    public ResponseEntity<List<Student>> getStudentList() {
        initStudentList();
        return ResponseEntity.ok(studentList);
    }
}
