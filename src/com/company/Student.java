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
    private static ArrayList<String> studentNumbers = new ArrayList<>();


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
                Check.addAllowed(studentNumber,studentNumbers);
                Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
                students.add(student);
                studentNumbers.add(studentNumber);
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
        Check.addAllowed(studentNumber,studentNumbers);
        Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
        students.add(student);
        studentNumbers.add(studentNumber);
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

    public static String searchInStudent(String searchedWord) {
        for (Student student : students){
            if (student.lastName.equals(searchedWord)){
                System.out.println(student.getStudentNumber()+"  "+student.entranceYear+"  "+student.average);
                return null;
            }
        }
//        for (int i = 0; i < students.size(); i++) {
//            Student checkingStudent = students.get(i);
//            if (checkingStudent.getLastName().equals(searchedWord)) {
//                Student student = students.get(i);
//                System.out.println("this is the student's number of the person you just searched "
//                        + student.getStudentNumber() + "\n");
//                // that's because if the lst if expression was true, the next text out of the for loop shouldn't be printed
//                return null;
//            }
//        }
        System.out.println("The entered name is not in system\n");
        return null;
    }


/**here are the getters for this class*/

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

/**here are the setter for the class
 * and we use them as delete part, because this parts of information can't be empty so,we don't need to delete , but just
 * reset them*/
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStudentField(String studentField) {
        this.studentField = studentField;
    }

    public void setEntranceYear(String entranceYear) {
        this.entranceYear = entranceYear;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
