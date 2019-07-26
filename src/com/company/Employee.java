package com.company;

import java.util.Scanner;

public class Employee extends Person {
    private String employeeNumber;
    private String entranceYear;

    public Employee(String firstName, String lastName, String employeeNumber, String entranceYear) {
        super(firstName, lastName);
        if (isNameValid(employeeNumber)) {
            this.employeeNumber = employeeNumber;
        }
        if (isNumberValid(entranceYear)) {
            this.entranceYear = entranceYear;
        }
    }

    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean isNameValid(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

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
    }
}

