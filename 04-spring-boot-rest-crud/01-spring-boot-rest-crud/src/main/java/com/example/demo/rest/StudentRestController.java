package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the Student data....only once!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Sudhanshu", "Tripathi"));
        theStudents.add(new Student("Shivanshu", "Prajapati"));
        theStudents.add(new Student("Divyansh", "Kushwaha"));
        theStudents.add(new Student("Vikas", "Kumar"));
    }

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define a endpoint or "/students/{studentId}" -- return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {  // parameter name should match the PathVariable name

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}
