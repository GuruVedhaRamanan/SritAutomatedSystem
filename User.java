package com.example.android.sritautomatedsystem;

public class User {

    private String Name;

    private String Year;

    private String Department;

    private String RegisterNumber;

    private String Block;

    private String RoomNumber;

    private String Floor;

    private String Mailid;

    private String Password;

    public User(String name, String year, String department, String registerNumber, String block, String roomNumber, String floor, String mailid, String password) {
        Name = name;
        Year = year;
        Department = department;
        RegisterNumber = registerNumber;
        Block = block;
        RoomNumber = roomNumber;
        Floor = floor;
        Mailid = mailid;
        Password = password;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {

        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String block) {
        Block = block;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getMailid() {
        return Mailid;
    }

    public void setMailid(String mailid) {
        Mailid = mailid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


