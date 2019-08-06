package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student.readStudent();
        Docent.readDocent();
        Employee.readEmployee();
        Course.readCourse();
        System.out.println(Student.getStudents());
        System.out.println(Docent.getDocents());
        System.out.println(Employee.getEmployees());
        System.out.println(Course.getCourses());
        Boolean key1 = true;
//                                           FIRST PAGE
        /** here is to guide the user to the next page that have options for different functions in the system*/
        System.out.println("Hello dear User");
        while (key1) {
            System.out.println("\nWhat do you want to do?\n-1-adding to the system" +
                    "\n-2-searching through the system\n-3-delete are change from the system\n-4-exit the system");
            Scanner scanner = new Scanner(System.in);
            String First = scanner.nextLine();
            switch (First) {
//                                             SECOND PAGE add
                /** first case is for adding new persons or fileds in the system as student employee docent or study fields*/

                case "1":
                    System.out.println("What do you want to add?\n-1-Student\n-2-Docent\n-3-Employee\n-4-Course");
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
                            Course.addToCourse();
                            break;
                    }
                    break;
//                                                 SECOND PAGE search
                /** this part will lead to the method that provides search function through array lists to find the wanted person or field*/
                case "2":
                    System.out.println("\nEnter the Last Name or Course Name you want to search ,same as it's entered in system\n     ");
                    String searchedWord = scanner.nextLine();
                    Student.searchInStudent(searchedWord);
                    Docent.searchInDocent(searchedWord);
                    Employee.searchInEmployee(searchedWord);
                    Course.searchInCourse(searchedWord);
                    break;
//                                                  SECOND PAGE delete or change
                /**this case will delete the persons object and any other information about the person*/
                //todo this part should be change to (do-while) loop
                case "3":
                    boolean whileAns = true;
                    while (whileAns) {
                        System.out.println("\ndo you want to -1- delete or -2- change?");
                        String deleteOrChange = scanner.nextLine();
                        if (deleteOrChange.equals("1")) {
                            System.out.println("\nFrom which group do you want to delete?\n-1-Student\n-2-Docent\n-3-Employee" +
                                    "\n-4-Course");
                            String whichDel = scanner.nextLine();
                            switch (whichDel) {
                                case "1":
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                default:
                                    System.out.println("wrong input");
                                    break;
                            }
                            whileAns = false;
                        } else if (deleteOrChange.equals("2")) {
                            System.out.println("\nIn which group do you want to change?\n-1-Student\n-2-Docent\n-3-Employee" +
                                    "\n-4-Course");
                            String whichCha = scanner.nextLine();
                            switch (whichCha) {
                                case "1":
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                default:
                                    System.out.println("wrong input");
                                    break;
                            }
                            whileAns = false;
                        } else {
                            System.out.println("\nyour input is wrong");
                        }
                    }


//                                                  SECOND PAGE
                    /** the last case is just in case that the person write a wrong input and willing to exit
                     *  or want to pick another option or just touched the wrong key*/
                case "4":
                    break;
                default:
                    System.out.println("\nyour entered code is wrong, please try again");
                    break;
            }
        }
    }
}


