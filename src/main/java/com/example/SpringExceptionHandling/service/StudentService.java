package com.example.SpringExceptionHandling.service;

import com.example.SpringExceptionHandling.dao.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student("James", 1, 82));
        students.add(new Student("Chris",2, 83));
        students.add(new Student("Jonas",3,80));
    }

    public boolean addStudentsDetails(Student student){
        return students.add(student);
    }

    public List<Student> getStudentsDetails() {
        return students;
    }

    public Student getStudentDetailsById(Long id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
}
