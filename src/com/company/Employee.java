package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Employee extends Person {
    private String employeeNumber;
    private String entranceYear;
    private static ArrayList<String> employeeNumbers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public Employee(String firstName, String lastName, String employeeNumber, String entranceYear) {
        super(firstName, lastName);
        if (Check.isValid(employeeNumber, '0', '9')) {
            this.employeeNumber = employeeNumber;
        }
        if (Check.isValid(entranceYear, '0', '9')) {
            this.entranceYear = entranceYear;
        }
    }

    /**
     * read from file and add to array list
     */
    public static void readEmployee() {
        try {
            File EmployeeFile = new File("resources/EmployeeFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(EmployeeFile));
            String stop = "";
            while ((stop = br.readLine()) != null) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                String employeeNumber = br.readLine();
                String entranceYear = br.readLine();
                Check.addAllowed(employeeNumber, employeeNumbers);
                Employee employee = new Employee(firstName, lastName, employeeNumber, entranceYear);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get from user,check the duplication of number,add to array list, write to text file
     */
    public static void addToEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee First name");
        String firsName = scanner.nextLine();
        System.out.println("Enter Employee Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Employee Number");
        String employeeNumber = scanner.nextLine();
        System.out.println("Enter Employee reputation");
        String entranceYear = scanner.nextLine();
        Check.addAllowed(employeeNumber, employeeNumbers);
        Employee employee = new Employee(firsName, lastName, employeeNumber, entranceYear);
        employees.add(employee);
        employeeNumbers.add(employeeNumber);
        writeEmployee(firsName, lastName, employeeNumber, entranceYear);
    }

    public static void writeEmployee(String firstName, String lastName, String employeeNumber, String entranceYear) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/EmployeeFile.txt", true));
            Random random = new Random();
            String n = String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
            bw.append(firstName);
            bw.newLine();
            bw.append(lastName);
            bw.newLine();
            bw.append(employeeNumber);
            bw.newLine();
            bw.append(entranceYear);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getters
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    //the other patern of doing that is to do without return anything
    public static void searchInEmployee(String searchedWord) {
        for (Employee employee : employees) {
            if (employee.lastName.equals(searchedWord)) {
                System.out.println("Employee: " + employee.firstName + "   " + employee.lastName + "   " + employee.employeeNumber + "  "
                        + employee.entranceYear);
                return;
            }
        }
        System.out.println("The entered name is not in Employees");
    }
//todo we have  a system for search that gives al information about person in the method ,so we don't actually need
// getter for each specific field
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

}

