package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Student extends Person {
    private String studentNumber;
    private String studentField;
    private String entranceYear;
    private String average;
    private static ArrayList<Student> students = new ArrayList<>();


    public Student(String firstName, String lastName, String studentNumber, String studentField, String entranceYear,
                   String average) {
        super(firstName, lastName);
        if (Check.isValid(studentNumber , '0' , '9')) {
            this.studentNumber = studentNumber;
        }
        if (Check.isValid(studentField, 'a', 'z')) {
            this.studentField = studentField;
        }
        if (Check.isValid(entranceYear, '0', '9')) {
            this.entranceYear = entranceYear;
        }
        if (Check.isValid(average, '0', '9', ".")) {
            this.average = average;
        }
        students.add(this);
    }

    //todo important : it seems that the two methods to  check inputs are not working, please check them out
    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                System.out.println("right input  " + number);
                return true;
            }
        }
        System.out.println("wrong input");

        return false;
    }


    /**
     * this method read the context from text file
     */
    public static void readStudent() {
        try {
            File studentFile = new File("resources/StudentFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(studentFile));
            String stop = "";
            while ((stop = br.readLine()) != null) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                String studentNumber = br.readLine();
                String studentField = br.readLine();
                String entranceYear = br.readLine();
                String average = br.readLine();
                Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method add the persons through user
     */
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
        Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
        students.add(student);
        // todo question : when i print the students array list , there are two times of each student in it, means, the
        //  students were added one time extra in the list, when i have no idea of that
        writeStudent(firstName, lastName, studentNumber, studentField, entranceYear, average);
    }

    /**
     * this method write the context from user to text file
     */
    public static void writeStudent(String firstName, String lastName, String studentNumber, String studentField,
                                    String entranceYear, String average) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/StudentFile.txt", true));
            Random random = new Random();
            String randomStr = String.valueOf(random.nextInt(300));
            bw.append(randomStr);
            bw.newLine();
            bw.append(firstName);
            bw.newLine();
            bw.append(lastName);
            bw.newLine();
            bw.append(studentNumber);
            bw.newLine();
            bw.append(studentField);
            bw.newLine();
            bw.append(entranceYear);
            bw.newLine();
            bw.append(average);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * here is given the last name or student number to define the object and then provide the deleting option
     * to erase the object from the list and text file
            * >>>Naive Algorithm :
            * <p>
     * 1. Create PrintWriter object for output.txt
     * 2. Open BufferedReader for input.txt
     * 3. Run a loop for each line of input.txt
     * 3.1 flag = false
            * 3.2 Open BufferedReader for delete.txt
     * 3.3 Run a loop for each line of delete.txt
     * ->  If  line of delete.txt is equal to current line of input.txt
     * -> flag = true
            * -> break loop
     * <p>
     * 4. Check flag, if false
            * -> write current line of input.txt to output.txt
     * 5. Flush PrintWriter stream and close resources.
            */
//    TODO Question : by deleting i found some methods like flush from class print writer and hashset
//     that i rather not use them as long as i don't know everything about them , do you have any other idea or
//     should i attempt to learn them from oracle.com
    public static void deleteFromStudent(String deletingWord) {

    }

    public static String searchInStudent(String searchedWord) {
//        TODO question : write this part of the search with for each loop , or at least give me a tip to find that easier
        for (int i = 0; i < students.size(); i++) {
            Person checkingPerson = students.get(i);
            if (checkingPerson.getLastName().equals(searchedWord)) {
                Student student = students.get(i);
                System.out.println("this is the student's number of the person you just searched "
                        + student.getStudentNumber() + "\n");
                // that's because if the lst if expression was true, the next text out of the for loop shouldn't be printed
                return null;
            }
        }
        System.out.println("The entered name is not in system\n");
        return null;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentField() {
        return studentField;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

    public String getAverage() {
        return average;
    }
}
