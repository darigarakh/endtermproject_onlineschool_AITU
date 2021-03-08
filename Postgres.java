package com.company.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {

        //connect to data base
        String connectionURL = "jdbc:postgresql://localhost:5432/endtermproject";
        try {
            // driver
            Class.forName("org.postgresql.Driver");
            // return connection with given user and password
            return DriverManager.getConnection(connectionURL, "postgres", "123456");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}