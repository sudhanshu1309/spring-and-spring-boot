package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Sudhanshu", "Tripathi"));
        theStudents.add(new Student("Shivanshu", "Prajapati"));
        theStudents.add(new Student("Divyansh", "Kushwaha"));
        theStudents.add(new Student("Vikas", "Kumar"));
        return theStudents;
    }
}
