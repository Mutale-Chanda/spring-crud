package com.codewithmut.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
