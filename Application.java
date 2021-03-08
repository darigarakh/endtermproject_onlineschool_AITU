package com.company.view;

import com.company.controller.GroupController;
import com.company.controller.StudentController;
import com.company.model.entities.Course;
import com.company.model.entities.Group;
import com.company.model.entities.Student;
import com.company.model.repositories.GroupRepository;
import com.company.model.repositories.IGroupRepository;
import com.company.model.repositories.IStudentRepository;
import com.company.model.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    // declare controllers
    private final GroupController groupController;
    private final StudentController studentController;

    public Application(IStudentRepository studentRepository, IGroupRepository groupRepository){
        groupController = new GroupController(groupRepository);
        studentController = new StudentController(studentRepository);
    }


    public void start(){

        // starting function
        System.out.println("Hello! Welcome to our school");

        Scanner in = new Scanner(System.in);

        while(true){ // endless while loop
            System.out.println("1: I am a teacher");
            System.out.println("2: I am a student");
            System.out.println("#: Exit");

            int choice = in.nextInt();

            if(choice == 1){ // if we are teacher
                System.out.println("1: Show all students");
                System.out.println("2: Show students from group");
                System.out.println("3: Show courses of student");
                System.out.println("4: Show group info");
                choice = in.nextInt();

                if(choice == 1){ // show all students
                    showAllStudents();
                } else if(choice == 2){ // show students from group
                    System.out.println("Enter group");
                    String group = in.next();
                    showStudentsFromGroup(group);
                } else if(choice == 3){ // show courses of student
                    System.out.println("Enter barcode");
                    int barcode = in.nextInt();
                    showCoursesOfStudent(barcode);
                } else if(choice == 4){ // show group info
                    System.out.println("Enter group");
                    String group = in.next();

                    showGroupInfo(group);
                }

            } else if(choice == 2){ // if we are a student
                System.out.println("Enter your barcode");
                int barcode = in.nextInt();
                System.out.println("1: Assign to new course");
                System.out.println("2: Show my courses");
                choice = in.nextInt();

                if(choice == 1){ // assiigning to a new course
                    System.out.println("Enter course name");
                    String cname = in.next();
                    studentController.assignToCourse(barcode, cname); // call controller's method assignToCourse(barcode, cname)
                } else if(choice == 2){ // show my courses
                    showCoursesOfStudent(barcode); // call function showCouresOfStudents which reciecves information from controller
                }
            } else {
                System.exit(0);
            }

        }

    }

    void showAllStudents(){
        // receive data from controller
        ArrayList<Student> studs = studentController.getAllStudents();


        for(Student to : studs){
            // output student's data
            System.out.println(to.toString());
        }
    }

    void showGroupInfo(String groupname){
        // receive data from controller
        Group g = groupController.getGroupInfo(groupname);

        // output group's data
        System.out.println(g.toString());

    }

    void showStudentsFromGroup(String group){
        // receive data from controller
        ArrayList < Student > g = groupController.getStudentsFromGroup(group);

        for(Student st : g){
            // output all student's data
            System.out.println(st.toString());
        }
    }

    void showCoursesOfStudent(int barcode){
        // receieve data from controller
        ArrayList <Course> c = studentController.getCoursesOfStudent(barcode);

        for(Course to : c){
            //output all courses
            System.out.println(to.toString());
        }
    }




}