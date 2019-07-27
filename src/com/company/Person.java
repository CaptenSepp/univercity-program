package com.company;
import java.util.ArrayList;

public class Person {
    public String firstName;
    public String lastName;

    //                           CONSTRUCTOR
    public Person(String firstName, String lastName) {
        if (isNameValid(firstName)) {
            this.firstName = firstName;
        }
        if (isNameValid(lastName)) {
            this.lastName = lastName;
        }
    }

    //                              CHECKING BLOCKS
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
}
