package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<> ();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student student: students) {
            if (student.getAverageGrade () == averageGrade)
                result = student;
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = null;
        double maxAverage = Double.MIN_VALUE;

        for (Student student: students) {
            if (student.getAverageGrade () > maxAverage) {
                maxAverage = student.getAverageGrade ();
                result = student;
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        Student result = null;
        double minAverage = Double.MAX_VALUE;

        for (Student student: students) {
            if (student.getAverageGrade () < minAverage) {
                minAverage = student.getAverageGrade ();
                result = student;
            }
        }
        return result;
    }

    public void expel(Student student) {
        //TODO:
        students.remove ( student );
    }
}