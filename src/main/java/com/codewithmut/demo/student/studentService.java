package com.codewithmut.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    public final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getAllStudents(){
        return studentRepository.findAll();
    }

    public student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("resource not found"));
    }

    public student saveStudent(student student){
        return studentRepository.save(student);
    }
}
