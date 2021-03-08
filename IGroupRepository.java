package com.company.model.repositories;

import com.company.model.entities.Group;
import com.company.model.entities.Student;

import java.util.ArrayList;

// interface for repository
public interface IGroupRepository {
    public Group getGroupInfo(String group);

    public ArrayList <Student> getStudentsFromGroup(String group);
}
