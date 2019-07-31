package com.company;

public class Person {
    protected String firstName;
    protected String lastName;

    //                           CONSTRUCTOR
    public Person(String firstName, String lastName) {
        char a = 'a';
        char z = 'z';
        char zero = '0';
        char nine = '9';
        if (Check.isValid(firstName, a, z)) {
            this.firstName = firstName;
        }
        if (Check.isValid(lastName, a, z)) {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
