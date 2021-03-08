package com.company.model.entities;

public class Group {
    private String name;
    private int numberOfStudents;
    private int maleCount;
    private int femaleCount;

    public Group(String name, int numberOfStudents, int maleCount, int femaleCount) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", maleCount=" + maleCount +
                ", femaleCount=" + femaleCount +
                '}';
    }
}
