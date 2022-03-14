package com.gl.emailApp.ui;

import java.util.Scanner;
import com.gl.emailApp.Employee;
import com.gl.emailApp.service.CredentialsGenerator;

public class EmailApplicationUI {
    public void init(){
        Employee employee=buildUI();
        callService(Employee);

    }

    private Employee buildUI(){
        buildWelcomeSection();
        Employee employee=buildEmployeeDetailsSection();
        return employee;
    }

    private void buildWelcomeSection(){
        System.out.println("*******************************");
        System.out.println("Welcome to the Email Application!");
        System.out.println("*******************************");
    }

    private Employee buildEmployeeDetailsSection(){
        Scanner userInput=new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName=userInput.nextLine();

        System.out.println("Enter your last name: ");
        String lastName=userInput.nextLine();

        System.out.println("Enter name of your department: ");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.println("Select 1/2/3/4 for your department.");
        int deptID=userInput.nextInt();
        String deptName=getDeptName(deptID);

        Employee employee=new Employee(firstName,lastName,deptName);

        userInput.close();

        return employee;

    }

    private String getDeptName(int deptID){

        if (deptID == 1) {
            return "Technical";
        }
        else if (deptID == 2) {
            return "Admin";
        }
        else if (deptID == 3) {
            return "Human Resource";
        }
        else if (deptID == 4) {
            return "Legal";
        }
        else {
            return "";
        }
    }

    private void callService(Employee employee){

        CredentialsGenerator generator=new CredentialsGenerator(employee);

        generator.generateEmailID();
        generator.generatePassword();
        generator.showCredentials();

    }
}
