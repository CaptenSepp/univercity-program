package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student.readStudent();
        Docent.readDocent();
        Employee.readEmployee();
        Field.readField();
        System.out.println(Student.getStudents());
        System.out.println(Docent.getDocents());
        System.out.println(Employee.getEmployees());
        System.out.println(Field.getFields());
        Boolean key1 = true;

//                                           FIRST PAGE
        /** here is to guide the user to the next page that have options for different functions in the system*/

        System.out.println("Hello dear User");
        while (key1) {
            System.out.println("What do you want to do?\n-1-adding to the system" +
                    "\n-2-searching through the system\n-3-delete from the system\n-4-exit the system");
            Scanner scanner = new Scanner(System.in);
            String First = scanner.nextLine();
            switch (First) {

//                                             SECOND PAGE add
                /** first case is for adding new persons or fileds in the system as student employee docent or study fields*/

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
                /** this part will lead to the method that provides search function through array lists to find the wanted person or field*/
                case "2":
                    System.out.println("Enter the Last Name you want to search ,same as it's entered in system\n     ");
                    String searchedWord = scanner.nextLine();
                    Student.searchInStudent(searchedWord);
//                    in this case ,when you search a word , it will show you just the student number of student
//                    bu it can be extended and results more information about the person who is searched
                    break;

//                                                  SECOND PAGE
                /**this case will delete the persons object and any other information about the person*/
                case "3":
                    System.out.println("From which group do you want to delete?\n-1-Student\n-2-Docent\n-3-Employee" +
                            "\n-4-Field");
                    String deletingWord = scanner.nextLine();
                    switch (deletingWord) {
                        case "1":
                            Student.deleteFromStudent(deletingWord);
                            break;
                        case "2":

                            break;
                        case "3":

                            break;
                        case "4":

                            break;
                        default:
                            break;
                    }

//                                                  SECOND PAGE
                    /** the last case is just in case that the person write a wrong input and willing to exit
                     *  or want to pick another option or just touched the wrong key*/
                case "4":
                    break;
                default:
                    System.out.println("your entered code is wrong, please try again");
                    break;
            }
        }
    }
}


