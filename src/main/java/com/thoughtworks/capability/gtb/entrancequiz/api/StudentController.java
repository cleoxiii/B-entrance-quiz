package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    public static List<Student> studentList;

    public StudentController() {
        initStudentList();
    }

    private void initStudentList() {
        studentList = new ArrayList<>();
        String[] students = new String[]{
                "沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇", "杨思雨", "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦",
                "黄云洁", "齐瑾浩", "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁",
                "马庆", "商婕", "余榕", "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "刘轲", "廖浚斌", "凌凤仪"
        };
        setDefaultStudent(studentList, students);
    }

    private void setDefaultStudent(List<Student> studentList, String[] students) {
        for (String student : students) {
            studentList.add(new Student(student));
        }
    }

    @GetMapping("/student-list")
    public ResponseEntity<List<Student>> getStudentList() {
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody String student) {
        studentList.add(new Student(student));
        return ResponseEntity.created(null).build();
    }
}