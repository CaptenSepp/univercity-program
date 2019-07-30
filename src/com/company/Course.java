package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Course {
    private String courseName;
    private String courseNumber;
    private String coursePoint;
    private String courseDate;
    private static ArrayList<Course> courses = new ArrayList<>();

    public Course(String courseName, String courseNumber, String coursePoint, String courseDate) {
        if (Check.isValid(courseName, 'a', 'z')) {
            this.courseName = courseName;
        }
        if (Check.isValid(courseNumber, '0', '9')) {
            this.courseNumber = courseNumber;
        }
        if (Check.isValid(coursePoint, '0', '9')) {
            this.coursePoint = coursePoint;
        }
    }


    public static void readField() {

        try {
            File fieldFile = new File("resources/FieldFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(fieldFile));

            String stop = "";
            while ((stop = br.readLine()) != null) {
                String fieldName = br.readLine();
                String fieldNumber = br.readLine();
                String fieldPoint = br.readLine();
                String fieldDate = br.readLine();
                Course course = new Course(fieldName, fieldNumber, fieldPoint, fieldDate);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course name");
        String fieldName = scanner.nextLine();
        System.out.println("Enter the course number");
        String fieldNumber = scanner.nextLine();
        System.out.println("Enter the course point");
        String fieldPoint = scanner.nextLine();
        System.out.println("Enter the course date");
        String fieldDate = scanner.nextLine();
        Course course = new Course(fieldName, fieldNumber, fieldPoint, fieldDate);
        courses.add(course);
        writeField(fieldName, fieldNumber, fieldPoint, fieldDate);
    }

    public static void writeField(String fieldName, String fieldNumber, String fieldPoint, String fieldDate) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/FieldFile.txt", true));
            Random random = new Random();
            String n= String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
            bw.append(fieldName);
            bw.newLine();
            bw.append(fieldNumber);
            bw.newLine();
            bw.append(fieldPoint);
            bw.newLine();
            bw.append(fieldDate);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCoursePoint() {
        return coursePoint;
    }

    public String getCourseDate() {
        return courseDate;
    }
}