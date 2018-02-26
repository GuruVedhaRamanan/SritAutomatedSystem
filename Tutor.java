package com.example.android.sritautomatedsystem;

/**
 * Created by MY PC on 25-02-2018.
 */

public class Tutor {

    private  String TutorId;

    private  String TutorName;

    private  String department;

    private  String password;

    private String year;

    public Tutor(String tutorId, String tutorName, String department, String password, String year) {
        TutorId = tutorId;
        TutorName = tutorName;
        this.department = department;
        this.password = password;
        this.year = year;
    }

    public String getTutorId() {
        return TutorId;
    }

    public void setTutorId(String tutorId) {
        TutorId = tutorId;
    }

    public String getTutorName() {
        return TutorName;
    }

    public void setTutorName(String tutorName) {
        TutorName = tutorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Tutor() {
    }
}
