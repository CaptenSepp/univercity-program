package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //    public static void main(String[]args) throws IOException {
//        File studentFile = new File("StudentFile.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(studentFile));
//
//        String st;
//        while ((st = br.readLine()) != null)
//            System.out.println(st);

        Boolean key1 = true;

//                                           FIRST PAGE
        System.out.println("Hello dear User");

        while (key1) {
            System.out.println("What do you want to do?\n-1-adding to the system" +
                    "\n-2-searching through the system\n-3-exit the system");
            Scanner scanner = new Scanner(System.in);
            String First = scanner.nextLine();
            switch (First) {

//                                             SECOND PAGE
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

//                                                 SECOND PAGE
                case "2":
//                    SearchPerson.searchInPerson(person.lastName);//TODO how doo you recommend that i try to search
//                     1for persons
                    break;

//                                                  SECOND PAGE
                case "3":
                    break;
                default:
                    System.out.println("your entered code is wrong, please try again");
                    break;
            }

        }
    }
}


