package com.company.controller;

import com.company.model.entities.Group;
import com.company.model.entities.Student;
import com.company.model.repositories.IGroupRepository;

import java.util.ArrayList;

public class GroupController {

    // store repository
    private final IGroupRepository repository;

    // constructor
    public GroupController(IGroupRepository repository) {
        this.repository = repository;
    }


    public Group getGroupInfo(String group){
        // receieve information from database
        return repository.getGroupInfo(group);
    }

    public ArrayList<Student> getStudentsFromGroup(String group){
        // receieve information from database
        return repository.getStudentsFromGroup(group);
    }
}