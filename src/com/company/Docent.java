package com.company;

import java.util.Scanner;

public class Docent extends Person {
    private String docentNumber;
    private String docentField;

    // TODO Question : if its valid or not, but the boolean method that i had can just check Strings, have you any new idea?
    public Docent(String firstName, String lastName, String docentNumber, String docentField) {
        super(firstName, lastName);
        if (isNameValid(docentNumber)) {
            this.docentNumber = docentNumber;
        }
        if (isNameValid(docentField)) {
            this.docentField = docentField;
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

    public static void addToDocent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Docent First name");
        String firstName = scanner.nextLine();
        System.out.println("Enter the Docent Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Docent number");
        String docentNumber = scanner.nextLine();
        System.out.println("Enter Docent field");
        String docentField = scanner.nextLine();
    }
}
