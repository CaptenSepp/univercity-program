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
        while (key1) {
            System.out.println("Hello\nWhat do you want to do?\n-1-adding to the system" +
                    "\n-2-searching through the system\n-3-exit the system");
            Scanner scanner = new Scanner(System.in);
            String First = scanner.nextLine();
            switch (First) {

//                                             SECOND PAGE
                case "1":
                    System.out.println("What do you want to add?\n-1-Student\n-2-Docent\n-3-Employee\n-4-Field");
                    Strung whichAdd = scanner.nextLine();
                    Person person = new Person();
                    switch (whichAdd) {
                        case "1":
                            AddPerson.addToPerson();
                            AddPerson.addToStudent():
                        case "2":
                            AddPerson.addToPerson();
                            AddPerson.addToDocent();
                        case "3":
                            AddPerson.addToPerson();
                            AddPerson.addToEmployee();
                        case "4":
                            AddPerson.addToPerson();
                            AddPerson.addToField();
                    }
                    break;

//                                                 SECOND PAGE
                case "2":
                    SearchPerson.searchInPerson(Person.lastName);
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


