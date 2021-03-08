package com.company.model.repositories;

import com.company.model.entities.Course;
import com.company.model.entities.Student;

import java.util.ArrayList;

// interface for repository
public interface IStudentRepository {

    public ArrayList<Student> getAllStudents();

    public void assignToCourse(int barocde, String course);

    public ArrayList <Course> getCoursesOfStudent(int barcode);
}
