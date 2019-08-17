package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Course {
    private String courseName;
    private String courseNumber;
    private int coursePoint = 0;
    private String courseTestDate;
    private static ArrayList<String> courseNumbers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public Course(String courseName, String courseNumber, int coursePoint, String courseTestDate) {
        if (Check.isValid(courseName, 'a', 'z')) {
            this.courseName = courseName;
        }
        if (Check.isValid(courseNumber, '0', '9')) {
            this.courseNumber = courseNumber;
        }
        /**check if the point is also allowed in system*/
        if (coursePoint < 5 && coursePoint > 1) {
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
                int coursePoint =Integer.valueOf(br.readLine());
                String courseTestDate = br.readLine();
                Check.addAllowed(courseNumber, courseNumbers);
                Course course = new Course(courseName, courseNumber, coursePoint, courseTestDate);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get from user,check the duplication of number,add to array list, write to text file
     */
    public static void addToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course name");
        String courseName = scanner.nextLine();
        System.out.println("Enter the course number");
        String courseNumber = scanner.nextLine();
        System.out.println("Enter the course point");
        int coursePoint = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the course date");
        String courseTestDate = scanner.nextLine();
        Course course = new Course(courseName, courseNumber, coursePoint, courseTestDate);
        courses.add(course);
        courseNumbers.add(courseNumber);
        writeCourse(courseName, courseNumber, coursePoint, courseTestDate);
    }

    public static void writeCourse(String courseName, String courseNumber, int coursePoint, String courseTestDate) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/CourseFile.txt", true));
            Random random = new Random();
            String n = String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
            bw.append(courseName);
            bw.newLine();
            bw.append(courseNumber);
            bw.newLine();
            bw.append(String.valueOf(coursePoint));
            bw.newLine();
            bw.append(courseTestDate);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Course searchInCourse(String searchedWord) {
        for (Course course : courses) {
            if (course.courseName.equals(searchedWord)) {
                System.out.println("Course: " + course.courseName + "   " + course.courseNumber + "  " + course.coursePoint + "  "
                        + course.courseTestDate);
                return course;
            }
        }
        System.out.println("The entered name is not in Courses");
        return null;
    }

    // getters
    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getCoursePoint() {
        return Integer.valueOf(coursePoint);
    }

    public String getcourseTestDate() {
        return courseTestDate;
    }
}