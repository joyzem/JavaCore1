package com.example.user.javacoretraining;

import com.example.user.javacoretraining.collections.CollectionsBlock.Task;
import com.example.user.javacoretraining.collections.CollectionsBlock.StudentsGroup;
import com.example.user.javacoretraining.collections.CollectionsBlock.Student;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
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
public class CollectionsTaskTest {

    private static Task task;

    @BeforeClass
    public static void init() {
        task = new Task(getStudentsGroups());
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
                new HashMap<String, Integer>() {{
                    put("Biology", 4);
                    put("English", 5);
                    put("Physics", 5);
                    put("History", 5);
                    put("Informatics", 5);
                }});

        Student student2A = new Student("Georgy", "Georgiev", "Vasilevich",
                2002, 1, groupA,
                new HashMap<String, Integer>() {{
                    put("Biology", 4);
                    put("English", 5);
                    put("Physics", 3);
                    put("History", 2);
                    put("Informatics", 5);
                }}
        );

        groupA.addStudents(Arrays.asList(student1A, student2A));
        return groupA;
    }

    private static StudentsGroup getSecondGroup() {

        StudentsGroup groupB = new StudentsGroup(1902);

        Student student1B = new Student("Andrey", "Alifirenko", "Aleksandrovich",
                2001, 2, groupB,
                new HashMap<String, Integer>() {{
                    put("Biology", 4);
                    put("English", 2);
                    put("Physics", 2);
                    put("History", 5);
                    put("Informatics", 5); }}
        );

        groupB.addStudents(student1B);
        return groupB;
    }
}
