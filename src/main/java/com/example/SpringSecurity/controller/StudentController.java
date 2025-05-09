package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Ram",89),
            new Student(2,"Ganesh",98)));

    @GetMapping("/students")
    public List<Student> getStudent(){
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("  /students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
