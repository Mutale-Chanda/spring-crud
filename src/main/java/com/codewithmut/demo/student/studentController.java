package com.codewithmut.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class studentController {
    private final studentService studentService;

    @Autowired
    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public student getStudent(@PathVariable("studentId") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public student createStudent(@RequestBody student student) {
        return studentService.saveStudent(student);
    }
}
