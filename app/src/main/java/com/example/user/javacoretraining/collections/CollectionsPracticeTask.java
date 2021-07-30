package com.example.user.javacoretraining.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
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
            displayGroupStatistic(group);
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

    private void displayGroupStatistic(StudentsGroup group) {
        System.out.printf("Group: %d\n", group.getGroupNumber());
        group.calculateGroupAverages();
        Student bestStudent = group.findBestStudent();
        System.out.printf("The best student of group %d: %s\n", group.getGroupNumber(),
                bestStudent.toString());
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

    public static class StudentsGroup {

        private int groupNumber;
        private SortedSet<Student> students;
        private ArrayList<Pair<String, Float>> groupSubjectsAverage;

        public StudentsGroup(int groupNumber) {
            this.groupNumber = groupNumber;
            students = new TreeSet<>();
            groupSubjectsAverage = new ArrayList<>();
        }

        public void calculateGroupAverages() {
            HashMap<String, Integer> subjectMarksSum = new HashMap<>();

            for(Student student: students) {
                for (Pair<String, Integer> subjectMarkMap : student.getSubjectMarkMap()) {
                    int mark = subjectMarkMap.getSecond();
                    String subject = subjectMarkMap.getFirst();

                    if (subjectMarksSum.containsKey(subject)) {
                        int newValue = subjectMarksSum.get(subject) + mark;
                        subjectMarksSum.put(subject, newValue);
                    } else {
                        subjectMarksSum.put(subject, mark);
                    }
                }
            }

            for (Map.Entry<String, Integer> subjectMarkSumMap : subjectMarksSum.entrySet()) {
                groupSubjectsAverage.add(new Pair<>(subjectMarkSumMap.getKey(),
                        (float) subjectMarkSumMap.getValue() / students.size()));
            }
            displayAverages();
        }

        public void displayAverages() {
            for (Pair<String, Float> subjectAveragePair : groupSubjectsAverage) {
                System.out.printf("%s: %.2f\n", subjectAveragePair.getFirst(), subjectAveragePair.getSecond());
            }
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

    public static class Student extends Person implements Comparable<Student> {

        private int courseNumber;
        private StudentsGroup group;
        private ArrayList<Pair<String, Integer>> subjectMarkMap;

        public Student(String name, String surname, String patronymic,
                       int birthdayYear, int courseNumber,
                       StudentsGroup group, ArrayList<Pair<String, Integer>> subjectMarkMap) {

            super(name, surname, patronymic, birthdayYear);
            this.courseNumber = courseNumber;
            this.group = group;
            this.subjectMarkMap = subjectMarkMap;
        }

        public ArrayList<Pair<String, Integer>> getSubjectMarkMap() {
            return subjectMarkMap;
        }

        public float getAverage() {
            int sum = 0;
            for (Pair<String, Integer> subjectMarkPair : subjectMarkMap) {
                sum += subjectMarkPair.getSecond();
            }
            return (float) sum / subjectMarkMap.size();
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
                    + ", subject map: " + subjectMarkMap;
        }
    }

    abstract static class Person {

        String name;
        String surname;
        String patronymic;
        int birthdayYear;

        public Person(String name, String surname, String patronymic, int birthdayYear) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.birthdayYear = birthdayYear;
        }

        public int compareTo(Person person) {
            int resultForSurname = changeToPlusMinusOneOrZero(this.surname.compareTo(person.surname));
            if (resultForSurname != 0) {
                return resultForSurname;
            }

            int resultForName = changeToPlusMinusOneOrZero(this.name.compareTo(person.name));
            if (resultForName != 0) {
                return resultForName;
            }

            return changeToPlusMinusOneOrZero(this.patronymic.compareTo(person.patronymic));
        }

        @Override
        public String toString() {
            return  "Name: '" + name + '\'' +
                    ", surname: '" + surname + '\'' +
                    ", patronymic: '" + patronymic + '\'';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (!name.equals(person.name)) return false;
            if (!surname.equals(person.surname)) return false;
            return patronymic.equals(person.patronymic);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + surname.hashCode();
            result = 31 * result + patronymic.hashCode();
            return result;
        }

        /**
         * Takes value and returns -1 if value is less than 0,
         * 1 if value is greater than 0, else 0
         *
         * @param value Integer
         * @return +- one or zero
         */
        private int changeToPlusMinusOneOrZero(int value) {
            if (value < 0) {
                return -1;
            }
            if (value > 0) {
                return 1;
            }
            return 0;
        }
    }

    public static class Pair<T, E> {

        private T t;
        private E e;

        public Pair(T t, E e) {
            this.t = t;
            this.e = e;
        }

        public T getFirst() {
            return t;
        }

        public E getSecond() {
            return e;
        }

        public void setFirst(T t) {
            this.t = t;
        }

        public void setSecond(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return t.toString() + ": " + e.toString();
        }
    }
}