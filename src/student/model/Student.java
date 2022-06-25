package student.model;

public class Student {

    private String name;
    private String surName;
    private int age;
    private double mark;
    private String gender;

    public Student() {}

    public Student(String name, String surName, int age, double mark, String gender) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.mark = mark;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMark() {
        return mark;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "name, " + name + ", " + "surName, " + surName + ", " + "age, " + age + ", " +
                "mark, " + mark + ", " + "gender, " + gender + '\n';
    }

    public void printInfo() {
        System.out.println("Student: " + '\n' + "name = " + name + '\n' + "surName = " + surName + '\n' +
                "age = " + age + '\n' + "mark = " + mark + '\n' + "gender = " + gender + '\n');
    }
}
