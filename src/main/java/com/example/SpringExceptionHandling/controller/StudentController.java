package com.example.SpringExceptionHandling.controller;

import com.example.SpringExceptionHandling.dao.Student;
import com.example.SpringExceptionHandling.exception.StudentException;
import com.example.SpringExceptionHandling.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudentsDetails();
    }

    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable Long id){
        Student student = studentService.getStudentDetailsById(id);
        if(student==null){
            throw new StudentException("Id is not available :" + id);
        }
        return student;

    }

    @PostMapping("/students")
    public boolean addStudents(@RequestBody Student student){
        return studentService.addStudentsDetails(student);
    }


}
