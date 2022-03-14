package com.gl.emailApp;

public class Employee {
    private String firstName;
    private String lastName;
    private String deptName;

    public Employee(String firstName,String lastName,String deptName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.deptName=deptName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public static void main(String[] args) {
        Employee akshat = new Employee("Akshat","Raizada","Technical");
        akshat.setFirstName("Akshat");

    }

}