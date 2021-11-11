package com.example.SpringExceptionHandling.controller;

import com.example.SpringExceptionHandling.dao.Student;
import com.example.SpringExceptionHandling.exception.StudentNotFoundException;
import com.example.SpringExceptionHandling.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList = studentService.getStudentsDetails();
        if(studentList.size() == 0){
            throw new StudentNotFoundException("No records available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable Long id){
        Student student = studentService.getStudentDetailsById(id);
        if(student==null){
            throw new StudentNotFoundException("Id is not available :" + id);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);

    }

    @PostMapping("/students")
    public boolean addStudents(@RequestBody Student student){
        return studentService.addStudentsDetails(student);
    }


}
