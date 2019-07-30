package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student.readStudent();
        Docent.readDocent();
        Employee.readEmployee();
        Field.readField();
        System.out.println(Student.getStudents());//todo question: here is said 'extends Person' what does it can mean?
        //TODO continue : because extend means erweitern <<GOSTARESH DADAN>>
        System.out.println(Docent.getDocents());
        System.out.println(Employee.getEmployees());
        System.out.println(Field.getFields());
        Boolean key1 = true;

//                                           FIRST PAGE
        System.out.println("Hello dear User");

        while (key1) {
            System.out.println("What do you want to do?\n-1-adding to the system" +
                    "\n-2-searching through the system\n-3-delete from the system\n-4-exit the system");
            Scanner scanner = new Scanner(System.in);
            String First = scanner.nextLine();
            switch (First) {

//                                             SECOND PAGE add
                case "1":
                    System.out.println("What do you want to add?\n-1-Student\n-2-Docent\n-3-Employee\n-4-Field");
                    String whichAdd = scanner.nextLine();
                    switch (whichAdd) {
                        case "1":
                            Student.addToStudent();
                            break;
                        case "2":
                            Docent.addToDocent();
                            break;
                        case "3":
                            Employee.addToEmployee();
                            break;
                        case "4":
                            Field.addToField();
                            break;
                    }
                    break;

//                                                 SECOND PAGE search
                case "2":
                    System.out.println("Enter the name as is entered in system\n");
                    String searchedWord = scanner.nextLine();
//                    TODO here ew should think of listing the object how that we be able to search in them or
//                     thinking of another way to search
                    if (Student.getStudents().contains(searchedWord)) {
                        System.out.println(Student.getStudents().get(Student.getStudents().indexOf(searchedWord)) + "\n");
                    } else {
                        System.out.println("The entered name is not in system\n");
                    }
                    break;
//                                                  SECOND PAGE
                case "3":
                    System.out.println("From which group do you want to delete?\n-1-Student\n-2-Docent\n-3-Employee" +
                            "\n-4-Field");
                    String deletedWord = scanner.nextLine();

//                                                  SECOND PAGE
                case "4":
                    break;
                default:
                    System.out.println("your entered code is wrong, please try again");
                    break;
            }

        }
    }
}


