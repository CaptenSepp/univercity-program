package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Docent extends Person {
    private String docentNumber;
    private String docentField;
    private static ArrayList<Docent> docents = new ArrayList<>();

    // TODO Question : if its valid or not, but the boolean method that i had can just check Strings, have you any new idea?
    public Docent(String firstName, String lastName, String docentNumber, String docentField) {
        super(firstName, lastName);
        if (isNameValid(docentNumber)) {
            this.docentNumber = docentNumber;
        }
        if (isNameValid(docentField)) {
            this.docentField = docentField;
        }

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

    public static void readDocent() {
        try {
            File docentFile = new File("resources/DocentFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(docentFile));

            String stop = "";
            while ((stop = br.readLine()) != null) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                String docentNumber = br.readLine();
                String docentField = br.readLine();
                Docent docent = new Docent(firstName, lastName, docentNumber, docentField);
                docents.add(docent);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToDocent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Docent First name");
        String firstName = scanner.nextLine();
        System.out.println("Enter the Docent Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Docent number");
        String docentNumber = scanner.nextLine();
        System.out.println("Enter Docent field");
        String docentField = scanner.nextLine();
        Docent docent = new Docent(firstName, lastName, docentNumber, docentField);
        docents.add(docent);
        writeDocent(firstName, lastName, docentNumber, docentField);
    }

    public static void writeDocent(String firstName, String lastName, String docentNumber, String docentField) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/DocentFile.txt", true));
//            TODO  Question : the Strings like firstName is not static because it can not be unique but method should be static
//             because we call it from main, i don't know what should i do now
            bw.append(firstName);
            bw.newLine();
            bw.append(lastName);
            bw.newLine();
            bw.append(docentNumber);
            bw.newLine();
            bw.append(docentField);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Docent> getDocents() {
        return docents;
    }
}
