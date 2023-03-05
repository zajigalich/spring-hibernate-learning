package com.my.rest;

import com.my.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData(){
        students = new ArrayList<>();
        students.add(new Student("One", "First"));
        students.add(new Student("Two", "Second"));
        students.add(new Student("Tree", "Third"));
    }

    //defining endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return students.get(studentId);
    }
}
