package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Course {
    private String courseName;
    private String courseNumber;
    private String coursePoint;
    private String courseTestDate;
    private static ArrayList<String> courseNumbers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public Course(String courseName, String courseNumber, String coursePoint, String courseTestDate) {
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


    public static void readCourse() {

        try {
            File courseFile = new File("resources/CourseFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(courseFile));

            String stop = "";
            while ((stop = br.readLine()) != null) {
                String courseName = br.readLine();
                String courseNumber = br.readLine();
                String coursePoint = br.readLine();
                String courseTestDate = br.readLine();
                Check.addAllowed(courseNumber,courseNumbers);
                Course course = new Course(courseName, courseNumber, coursePoint, courseTestDate);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course name");
        String courseName = scanner.nextLine();
        System.out.println("Enter the course number");
        String courseNumber = scanner.nextLine();
        System.out.println("Enter the course point");
        String coursePoint = scanner.nextLine();
        System.out.println("Enter the course date");
        String courseTestDate = scanner.nextLine();
        Course course = new Course(courseName, courseNumber, coursePoint, courseTestDate);
        courses.add(course);
        courseNumbers.add(courseNumber);
        writeCourse(courseName, courseNumber, coursePoint, courseTestDate);
    }

    public static void writeCourse(String courseName, String courseNumber, String coursePoint, String courseTestDate) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/CourseFile.txt", true));
            Random random = new Random();
            String n= String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
            bw.append(courseName);
            bw.newLine();
            bw.append(courseNumber);
            bw.newLine();
            bw.append(coursePoint);
            bw.newLine();
            bw.append(courseTestDate);
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

    public String getcourseTestDate() {
        return courseTestDate;
    }
}