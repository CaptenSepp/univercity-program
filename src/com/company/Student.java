package com.company;

import java.util.Scanner;

public class Student extends Person {
    private String studentNumber;
    private String studentField;
    private String entranceYear;
    private String average;// TODO Question : i wanted to make it a float,is it efficient ? and then i wanted to check

    // if its valid or not, but the boolean method that i had can just check Strings, have you any new idea?
    public Student(String firstName, String lastName, String studentNumber, String studentField, String entranceYear, String average) {
        super(firstName, lastName);
        if (isNameValid(studentNumber)) {
            this.studentNumber = studentNumber;
        }
        if (isNameValid(studentField)) {
            this.studentField = studentField;
        }
        if (isNumberValid(entranceYear)) {
            this.entranceYear = entranceYear;
        }
        if (isNumberValid(average)) {
            this.average = average;
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

    public static void addToStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the First name");
        String firstName = scanner.nextLine();
        System.out.println("Enter the Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter the Student number");
        String studentNumber = scanner.nextLine();
        System.out.println("Enter the Student filed");
        String studentField = scanner.nextLine();
        System.out.println("Enter the entrance year");
        String entranceYear = scanner.nextLine();
        System.out.println("Enter the Average");
        String average = scanner.nextLine();

    }
}
