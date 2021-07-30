package com.example.user.javacoretraining.collections.practice_task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class StudentsGroup {

    private int groupNumber;
    private SortedSet<Student> students;
    private ArrayList<Subject> subjectsAverages;

    public StudentsGroup(int groupNumber) {
        this.groupNumber = groupNumber;
        students = new TreeSet<>();
        subjectsAverages = new ArrayList<>();
    }

    public void calculateGroupAverages() {
        HashMap<String, Float> subjectsMarksMap = new HashMap<>();

        for (Student student : students) {
            for (Subject subject : student.getSubjects()) {
                float mark = subject.getMark();
                String subjectName = subject.getSubjectName();

                if (subjectsMarksMap.containsKey(subjectName)) {
                    float newValue = subjectsMarksMap.get(subjectName) + mark;
                    subjectsMarksMap.put(subjectName, newValue);
                } else {
                    subjectsMarksMap.put(subjectName, mark);
                }
            }
        }

        for (Map.Entry<String, Float> subjectMarkSumMap : subjectsMarksMap.entrySet()) {
            subjectsAverages.add(new Subject(subjectMarkSumMap.getKey(),
                    (float) subjectMarkSumMap.getValue() / students.size()));
        }
    }

    public void displayAverages() {
        for (Subject subjectAveragePair : subjectsAverages) {
            System.out.printf("%s: %.2f\n",
                    subjectAveragePair.getSubjectName(), subjectAveragePair.getMark());
        }
    }

    public void displayGroupStatistic() {
        System.out.printf("Group: %d\n", groupNumber);
        calculateGroupAverages();
        displayAverages();
        Student bestStudent = findBestStudent();
        System.out.printf("The best student of group %d: %s\n", groupNumber,
                bestStudent.toString());
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public Student findBestStudent() {
        float bestAverage = students.first().getAverage();
        Student bestStudent = students.first();

        for (Student student : students) {
            if (student.getAverage() > bestAverage) {
                bestAverage = student.getAverage();
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public Set<Student> getAllStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsGroup that = (StudentsGroup) o;

        return groupNumber == that.groupNumber;
    }

    @Override
    public int hashCode() {
        return groupNumber;
    }
}
