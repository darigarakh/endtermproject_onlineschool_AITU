package com.company.controller;

import com.company.model.entities.Course;
import com.company.model.entities.Student;
import com.company.model.repositories.IStudentRepository;

import java.util.ArrayList;

public class StudentController {

    private final IStudentRepository repository; // store repository

    // constructor
    public StudentController(IStudentRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Student> getAllStudents(){
        // receive info from database
        return repository.getAllStudents();
    }

    public void assignToCourse(int barcode, String course){
        // receive info from database
        repository.assignToCourse(barcode, course);
    }

    public ArrayList <Course> getCoursesOfStudent(int barcode){
        // receive info from database
        return repository.getCoursesOfStudent(barcode);
    }
}
