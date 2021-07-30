package com.example.user.javacoretraining;

import com.example.user.javacoretraining.collections.CollectionsPracticeTask;
import com.example.user.javacoretraining.collections.CollectionsPracticeTask.*;



import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
     Задание подразумевает создание класса(ов) для выполнения задачи.

     Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
     курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
     Упорядочите студентов по курсу, причем студенты одного курса располагались
     в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
     Определите самого старшего студента и самого младшего студентов.
     Для каждой группы найдите лучшего с точки зрения успеваемости студента.
    */
public class CollectionsTaskTest {

    private static CollectionsPracticeTask task;

    @BeforeClass
    public static void init() {
        task = new CollectionsPracticeTask(getStudentsGroups());
    }

    @Test
    public void performTask() {
        task.displayStudents();
        task.displayGroupsStatistics();
        task.displayYoungestStudent();
        task.displayEldestStudent();
    }

    private static Set<StudentsGroup> getStudentsGroups() {
        return new HashSet<>(Arrays.asList(getFirstGroup(), getSecondGroup()));
    }

    private static StudentsGroup getFirstGroup() {

        StudentsGroup groupA = new StudentsGroup(2002);

        Student student1A = new Student("Vlad", "Popov", "Ivanovich",
                2003, 1, groupA,
                new ArrayList<Pair<String, Integer>>() {{
                    add(new Pair("Biology", 4));
                    add(new Pair( "English", 5));
                    add(new Pair("Physics", 5));
                    add(new Pair("History", 5));
                    add(new Pair("Informatics", 5));
                }}
        );

        Student student2A = new Student("Georgy", "Georgiev", "Vasilevich",
                2002, 1, groupA,
                new ArrayList<Pair<String, Integer>>() {{
                    add(new Pair("Biology", 4));
                    add(new Pair( "English", 5));
                    add(new Pair("Physics", 3));
                    add(new Pair("History", 2));
                    add(new Pair("Informatics", 5));
                }}
        );

        groupA.addStudents(Arrays.asList(student1A, student2A));
        return groupA;
    }

    private static StudentsGroup getSecondGroup() {

        StudentsGroup groupB = new StudentsGroup(1902);

        Student student1B = new Student("Andrey", "Alifirenko", "Aleksandrovich",
                2001, 2, groupB,
                new ArrayList<Pair<String, Integer>>() {{
                    add(new Pair("Biology", 4));
                    add(new Pair( "English", 2));
                    add(new Pair("Physics", 2));
                    add(new Pair("History", 5));
                    add(new Pair("Informatics", 2));
                }}
        );

        groupB.addStudents(student1B);
        return groupB;
    }
}
