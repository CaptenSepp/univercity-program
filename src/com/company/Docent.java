package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Docent extends Person {
    private String docentNumber;
    private String docentField;
    private static ArrayList<Docent> docents = new ArrayList<>();

    public Docent(String firstName, String lastName, String docentNumber, String docentField) {
        super(firstName, lastName);
        if (Check.isValid(docentNumber, '0', '9')) {
            this.docentNumber = docentNumber;
        }
        if (Check.isValid(docentField, 'a', 'z')) {
            this.docentField = docentField;
        }
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
            Random random = new Random();
            String n = String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
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

    public String getDocentNumber() {
        return docentNumber;
    }

    public String getDocentField() {
        return docentField;
    }
}
