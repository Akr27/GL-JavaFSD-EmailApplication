package com.gl.emailApp.service;

import java.util.Locale;
import java.util.Random;
import com.gl.emailApp.Employee;


public class CredentialsGenerator {
    private Employee employee;

    private String generatedEmailID;
    private char[] generatedPassword= new char[8];

    public CredentialsGenerator(Employee employee){
        this.employee=employee;
    }

    public void generateEmailID(){
        String departmentShortName = getDepartmentSortName();
        String emailID = employee.getFirstName().toLowerCase(Locale.ROOT)+"."+employee.getLastName().toLowerCase(Locale.ROOT)+"@"+departmentShortName+".gl.com";

        this.generatedEmailID=emailID;
    }

    private String getDepartmentSortName(){
        String deptName = employee.getDeptName();

        if(deptName.equals("Technical")){
            return "tech";
        }
        else if(deptName.equals("Legal")){
            return "lgl";
        }
        else if(deptName.equals("Admin")){
            return "adm";
        }
        else if(deptName.equals("Human Resource")){
            return "hr";
        }
        return "";

    }

    public void generatePassword(){
        String capitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters="abcdefghijklmnopqrstuvwxyz";
        String numbers="0123456789";
        String specialCharacters="!@#$%^&*_+=?|";

        String allValues=capitalLetters+smallLetters+numbers+specialCharacters;

        Random randomObj=new Random();

        for(int i=0;i<8;i++){
            int boundValue=allValues.length();
            int randomIndex=randomObj.nextInt(boundValue);
            char randomChar=allValues.charAt(randomIndex);
            this.generatedPassword[i]=randomChar;
        }
    }

    public void showCredentials(){
        System.out.print("Dear "+employee.getFirstName()+",");
        System.out.println("Your generated credentials are as follows:");
        System.out.println("Email ID: "+generatedEmailID);
        System.out.println("Password: "+generatedPassword);
    }

}
