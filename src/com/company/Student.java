package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Student extends Person {
    private String studentNumber;
    private String studentField;
    private String entranceYear;
    private String average;// TODO Question : i wanted to make it a float,is it efficient ? and then i wanted to check
    private static ArrayList<Student> students = new ArrayList<>();


    public Student(String firstName, String lastName, String studentNumber, String studentField, String entranceYear,
                   String average) {
        super(firstName, lastName);
        if (isNameValid(studentNumber)) {
            this.studentNumber = studentNumber;
        }
        if (isNameValid(studentField)) {
            this.studentField = studentField;
        }
        if (isNumberValid(entranceYear)) {
            this.entranceYear = entranceYear;
        }
        if (isNumberValid(average)) {
            this.average = average;
        }
        students.add(this);
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
        writeStudent(firstName, lastName, studentNumber, studentField, entranceYear, average);
    }

    /**
     * this method write the context from user to text file
     */
    public static void writeStudent(String firstName, String lastName, String studentNumber, String studentField,
                                    String entranceYear, String average) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/StudentFile.txt", true));
//            TODO  Question : the Strings like firstName is not static because it can not be unique but method should be static
//             because we call it from main, i dont know wwhat should i do now
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
    /**here is given the lastname or student number to define the object and then provide the deleting option
     * to erase the object from the list and text file
     * >>>Naive Algorithm :
     *
     * 1. Create PrintWriter object for output.txt
     * 2. Open BufferedReader for input.txt
     * 3. Run a loop for each line of input.txt
     *    3.1 flag = false
     *    3.2 Open BufferedReader for delete.txt
     *    3.3 Run a loop for each line of delete.txt
     *       ->  If  line of delete.txt is equal to current line of input.txt
     *             -> flag = true
     *             -> break loop
     *
     * 4. Check flag, if false
     *      -> write current line of input.txt to output.txt
     * 5. Flush PrintWriter stream and close resources.*/
//    TODO Question : by deleting i found some methods like flush from class print writer and hashset
//     that i rather not use them as long as i don't know everything about them , do you have any other idea or
//     should i attempt to learn them from oracle.com
    public static void deleteFromStudent(){

    }
    public static ArrayList<Student> getStudents() {
        return students;
    }
}
