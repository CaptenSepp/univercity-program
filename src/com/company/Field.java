package com.company;

import java.util.Scanner;

public class Field {
    private String fieldName;
    private String fieldNumber;
    private String fieldPoint;
    private String fieldDate;

    public Field(String fieldName, String fieldNumber, String fieldPoint, String fieldDate) {
        if (isNameValid(fieldName)) {
            this.fieldName = fieldName;
        }
        if (isNameValid(fieldNumber)) {
            this.fieldNumber = fieldNumber;
        }
        if (isNumberValid(fieldPoint)) {
            this.fieldPoint = fieldPoint;
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

    public static void addToField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the field name");
        String fieldName = scanner.nextLine();
        System.out.println("Enter the field number");
        String fieldNumber = scanner.nextLine();
        System.out.println("Enter the field point");
        String fieldPoint = scanner.nextLine();
        System.out.println("Enter the field date");
        String fieldDate = scanner.nextLine();
    }
}