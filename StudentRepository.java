package com.company.model.repositories;

import com.company.model.database.IDB;
import com.company.model.entities.Course;
import com.company.model.entities.Group;
import com.company.model.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {

    // store database
    private final IDB db;

    // constructor
    public StudentRepository(IDB db) {
        this.db = db;
    }

    // receieve all students from database
    public ArrayList<Student> getAllStudents(){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList<Student> res = new ArrayList<>();

        try {

            con = db.getConnection();
            st = con.createStatement();
            // sql query
            rs = st.executeQuery("select * from students");


            // add data from all rows
            while(rs.next()){
                res.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

            // return data

            return res;

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }

        return null;
    }



    public void assignToCourse(int barcode, String course){
        Connection con = null;
        ResultSet rs = null;

        int male = 0;
        int female = 0;


        try {
            con = db.getConnection(); // connect

            // sql statement
            String sql = "insert into courses values(?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, barcode);
            st.setString(2, course);


            // executing statement
            st.execute();

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public ArrayList <Course> getCoursesOfStudent(int barcode){
        Connection con = null;
        ResultSet rs = null;

        ArrayList < Course > c = new ArrayList<>();

        try {
            con = db.getConnection();


            // sql query
            String sql = "select * from courses where barcode=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, barcode);

            //execute query

            rs = st.executeQuery();

            // add data from all rows

            while(rs.next()){
                c.add(new Course(rs.getString(2)));
            }

            // return data

            return c;


        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return null;
    }
}
