package com.nagatechworld.app.controller;

import com.nagatechworld.app.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student-deatiles
    @GetMapping("/student-deatiles")
    public Student getStudentDetailes(){
        Student student=new Student(12,"naga","lakshmi",21);
        return  student;
    }

    //http://localhost:8080/students-detailes
    @GetMapping("/students-detailes")
    public List<Student> getStudentsDetailes(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(22,"Kittu","Mundru",23));
        students.add(new Student(22,"Mandava","Naga",23));
        students.add(new Student(22,"Rama","Krishna",23));
        students.add(new Student(22,"Krishna","Mundru",23));
        return students;
    }

}
