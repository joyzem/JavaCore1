package com.example.user.javacoretraining.collections.practice_task;

import java.util.ArrayList;

public class Student extends Person implements Comparable<Student> {

    private int courseNumber;
    private StudentsGroup group;
    private ArrayList<Subject> subjects;

    public Student(String name, String surname, String patronymic,
                   int birthdayYear, int courseNumber,
                   StudentsGroup group, ArrayList<Subject> subjects) {

        super(name, surname, patronymic, birthdayYear);
        this.courseNumber = courseNumber;
        this.group = group;
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public float getAverage() {
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getMark();
        }
        return (float) sum / subjects.size();
    }

    public int compareTo(Student s) {
        if (courseNumber > s.getCourseNumber()) {
            return 1;
        } else if (courseNumber == s.getCourseNumber()) {
            return super.compareTo(s);
        } else {
            return -1;
        }
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ",\n course number: " + courseNumber
                + ", group number: " + group.getGroupNumber()
                + ", subject map: " + subjects;
    }
}
