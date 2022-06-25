package student.service;

import student.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.Scanner;

public class StudentService {

    public static void startMenu() throws IOException {
        Scanner s = new Scanner(System.in);
        boolean isActiveMenu = true;
        while (isActiveMenu) {
            System.out.println("--------Menu--------");
            System.out.println("1. Create students");
            System.out.println("2. Print first student");
            System.out.println("3. Print last student");
            System.out.println("4. Print all student info");
            System.out.println("5. Print all female student info");
            System.out.println("6. Print all male student info");
            System.out.println("7. Print oldest student info");
            System.out.println("8. Print student(highest mark)");
            System.out.println("9. Search student by name");
            System.out.println("10. Exit");
            int menuNumber = s.nextInt();
            switch (menuNumber) {
                case 1:
                    createStudent();
                    System.out.println("Created student!");
                    break;
                case 2:
                    firstStudent();
                    break;
                case 3:
                    lastStudent();
                    break;
                case 4:
                    printAllStudent();
                    break;
                case 5:
                    printAllFemale();
                    break;
                case 6:
                    printAllMale();
                    break;
                case 7:
                    oldestStudent();
                    break;
                case 8:
                    highestMark();
                    break;
                case 9:
                    searchByName();
                    break;
                case 10:
                    isActiveMenu = false;
                    break;
                default:
                    System.err.println("Input number is incorrect");
            }
        }
    }

    public static void createStudent() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = s.nextLine();
        System.out.println("Input surName: ");
        String surName = s.nextLine();
        System.out.println("Input age: ");
        int age = Integer.parseInt(s.nextLine());
        System.out.println("Input mark: ");
        double mark = Double.parseDouble(s.nextLine());
        System.out.println("Input gender");
        String gender = s.nextLine();
        Student student = new Student(name, surName, age, mark, gender);
        Files.write(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt"),
                student.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void firstStudent() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
        }
        students[0].printInfo();
    }

    public static void lastStudent() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
        }
        students[students.length - 1].printInfo();
    }

    public static void printAllStudent() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
            students[i].printInfo();
        }
    }

    public static void printAllFemale() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
            if (Objects.equals(students[i].getGender(), "female")) {
                students[i].printInfo();
            }
        }
    }

    public static void printAllMale() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
            if (Objects.equals(students[i].getGender(), "male")) {
                students[i].printInfo();
            }
        }
    }

    public static void oldestStudent() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
        }
        Student oldStudent = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldStudent.getAge()) {
                oldStudent = students[i];
            }
        }
        oldStudent.printInfo();
    }

    public static void highestMark() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
        }
        Student highestMark = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMark() > highestMark.getMark()) {
                highestMark = students[i];
            }
        }
        highestMark.printInfo();
    }

    private static void searchByName() throws IOException {
        String[] read = Files.readAllLines(Path.of("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt")).toArray(new String[0]);
        Student[] students = new Student[read.length];
        for (int i = 0; i < read.length; i++) {
            String[] split = read[i].split(", ");
            Student student = new Student(split[1], split[3], Integer.parseInt(split[5]),
                    Double.parseDouble(split[7]), split[9]);
            students[i] = student;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                student.printInfo();
            }
        }
    }
}
