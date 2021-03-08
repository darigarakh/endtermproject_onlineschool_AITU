package com.company.model.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {


    // interface to all databases(postgre mysql etc.)
    Connection getConnection() throws SQLException, ClassNotFoundException;
}