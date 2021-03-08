package com.company;

import com.company.model.database.IDB;
import com.company.model.database.Postgres;
import com.company.model.repositories.GroupRepository;
import com.company.model.repositories.IGroupRepository;
import com.company.model.repositories.IStudentRepository;
import com.company.model.repositories.StudentRepository;
import com.company.view.Application;

public class Main {

    public static void main(String[] args) {

        // to store database
        IDB database = new Postgres();

        // create repositoriies
        IGroupRepository groupRepository = new GroupRepository(database);
        IStudentRepository studentRepository = new StudentRepository(database);

        // create applocation variable
        Application app = new Application(studentRepository, groupRepository);

        // start our starting function from application
        app.start();

    }

}