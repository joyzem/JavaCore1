package com.example.user.javacoretraining.collections.practice_task;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/*
  Задание подразумевает создание класса(ов) для выполнения задачи.

  Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
  курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
  Упорядочите студентов по курсу, причем студенты одного курса располагались
  в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
  Определите самого старшего студента и самого младшего студентов.
  Для каждой группы найдите лучшего с точки зрения успеваемости студента.
 */

public class CollectionsPracticeTask {

    TreeSet<Student> students;
    HashSet<StudentsGroup> groups;

    public CollectionsPracticeTask(Set<StudentsGroup> groups) {
        this.groups = new HashSet<>(groups);
        this.students = new TreeSet<>(getAllStudentsFromGroups());
    }

    public void displayGroupsStatistics() {
        for (StudentsGroup group : groups) {
            group.displayGroupStatistic();
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void displayYoungestStudent() {
        System.out.printf("The youngest student is: \n%s\n", findYoungestStudent().toString());
    }

    public void displayEldestStudent() {
        System.out.printf("The eldest students is: \n%s\n", findEldestStudent().toString());
    }

    private Student findYoungestStudent() {
        Student youngestStudent = students.first();
        for (Student student : students) {
            if (student.birthdayYear > youngestStudent.birthdayYear) {
                youngestStudent = student;
            }
        }
        return youngestStudent;
    }

    private Student findEldestStudent() {
        Student eldestStudent = students.first();

        for (Student student : students) {
            if (student.birthdayYear < eldestStudent.birthdayYear) {
                eldestStudent = student;
            }
        }
        return eldestStudent;
    }

    private Set<Student> getAllStudentsFromGroups() {
        Set<Student> students = new TreeSet<>();
        for (StudentsGroup group : groups) {
            students.addAll(group.getAllStudents());
        }
        return students;
    }

}