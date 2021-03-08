package com.company.model.repositories;

import com.company.model.database.IDB;
import com.company.model.entities.Group;
import com.company.model.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupRepository implements IGroupRepository{

    private final IDB db;

    public GroupRepository(IDB db) {
        this.db = db;
    }

    public Group getGroupInfo(String group){

        Connection con = null;
        ResultSet rs = null;


        // store male and female count
        int male = 0;
        int female = 0;


        try {
            con = db.getConnection();
            // sql query
            String sql = "select * from students where group_name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, group);

            // execute query
            rs = st.executeQuery();


            // add data from all rows
            while(rs.next()){
                // check if male or not
                if(rs.getString(4).equals("male")){
                    male++;
                } else {
                    female++;
                }
            }

            // return data from database

            return new Group(group, male + female, male, female);


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


    public ArrayList<Student> getStudentsFromGroup(String group){
        Connection con = null;
        ResultSet rs = null;

        ArrayList<Student> res = new ArrayList<>();

        try {
            con = db.getConnection();

            // sql query

            String sql = "select * from students where group_name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, group);


            // execute query
            rs = st.executeQuery();


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
}
