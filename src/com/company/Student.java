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
    private int totalStudentCoursePoint;
    private int studentCorrections = 0;
    private double physic;
    private double mathe;
    private double chemie;
    private double english;
    private double deutsch;
    // todo question : now these array lists bellow are stored in the objects location??? they are statics i mean
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<String> studentNumbers = new ArrayList<>();
    private ArrayList<Course> studentCourses = new ArrayList<>();
    private Double[] studentNotes = new Double[5];

    public Student(String firstName, String lastName, String studentNumber, String studentField, String entranceYear,
                   String average) {
        super(firstName, lastName);
        if (Check.isValid(studentNumber, '0', '9')) {
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
            //todo question : what dou you mean by broadcasting a student as M-A-S-H-R-U-T ???
        }
//        students.add(this);
    }

    /**
     * read the context from text file
     */
    public static void readStudent() {
        try {
            File studentFile = new File("resources/StudentFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(studentFile));
            String stop = new String();
            while ((stop = br.readLine()) != null) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                String studentNumber = br.readLine();
                String studentField = br.readLine();
                String entranceYear = br.readLine();
                String average = br.readLine();
                Check.addAllowed(studentNumber, studentNumbers);
                Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
                students.add(student);
                readStudentNote(student);
                studentNumbers.add(studentNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get from user,check the duplication of number,add to array list, write to text file
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
        Check.addAllowed(studentNumber, studentNumbers);
        Student student = new Student(firstName, lastName, studentNumber, studentField, entranceYear, average);
        students.add(student);
        studentNumbers.add(studentNumber);
        // todo question : when i print the students array list , there are two times of each student in it, means, the
        //  students were added one time extra in the list, when i have no idea of that
        writeStudent(firstName, lastName, studentNumber, studentField, entranceYear, average);
    }

    /**
     * write the context from user to text file
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

    public static Student searchInStudent(String searchedWord) {
        for (Student student : students) {
            if (student.lastName.equals(searchedWord)) {
                System.out.println("Student: " + student.firstName + "   " + student.lastName + "   " + student.studentNumber + "  "
                        + student.entranceYear + "  " + student.average + "   " + student.getStudentNotes());
                //todo : the output of student notes when the system find the person is wrong, and gives the address of the list
                return student;
            }
        }
        System.out.println("The entered name is not in Students");
        return null;
    }

    /**
     * getters
     */
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

    public static ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * setter and we use them as delete part
     */
    public void setStudentNumber(String studentNumber) {//todo question : when we change the detail through setter then we have to write it again in the text file ,should i write a class for writing things in the text file to make it once?
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

    /**
     * add new Course in students list
     */
    public void setAddStudentCoursesLimit(Course newCourse) {
        // todo : these are corrections time out for student , just two times
//        if (studentCorrections<2) {
//            studentCorrections += 1;
        if (totalStudentCoursePoint + Integer.valueOf(newCourse.getCoursePoint()) < 21) {
            studentCourses.add(newCourse);
            totalStudentCoursePoint += Integer.valueOf(newCourse.getCoursePoint());
        }
    }

    private static void writeStudentNote() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/NEW FILE HERE.txt", true));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double[] getStudentNotes() {
        return studentNotes;
    }

    private static void readStudentNote(Student student) {
        try {
            File studentNote = new File("resources/HashSepp.txt");
            BufferedReader br = new BufferedReader(new FileReader(studentNote));
            String stop;
            while ((stop = br.readLine()) != null) {
                //todo question : is that right how i wrote that the code below , i wanted that the
                // last and first name be checked before adding to the person?
                if (stop.equals(student.lastName + student.firstName)) {
                    double physic = Double.valueOf(br.readLine());
                    double mathe = Double.valueOf(br.readLine());
                    double chemie = Double.valueOf(br.readLine());
                    double english = Double.valueOf(br.readLine());
                    double deutsch = Double.valueOf(br.readLine());
                    //todo question : how can i write that with a for loop ?
                    student.studentNotes[0] = physic;
                    student.studentNotes[1] = mathe;
                    student.studentNotes[2] = chemie;
                    student.studentNotes[3] = english;
                    student.studentNotes[4] = deutsch;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/**
 * to make a list of Doubles
 * //    List<Double> doubles = new ArrayList<Double>(initialCapacity);
 * <p>
 * <p>
 * <p>
 * <p>
 * //        for (int i = 0; i < students.size(); i++) {
 * //            Student checkingStudent = students.get(i);
 * //            if (checkingStudent.getLastName().equals(searchedWord)) {
 * //                Student student = students.get(i);
 * //                System.out.println("this is the student's number of the person you just searched "
 * //                        + student.getStudentNumber() + "\n");
 * //                // that's because if the lst if expression was true, the next text out of the for loop shouldn't be printed
 * //                return null;
 * //            }
 * //        }
 */