package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {

    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) {

        if (firstList == null || secondList == null) throw new NullPointerException();

        List<T> newList = new LinkedList<>();

        int minSize = Math.min(firstList.size(), secondList.size());

        int firstListIndex = 0;
        int secondListIndex = 0;

        for (; firstListIndex < minSize && secondListIndex < minSize;) {
            if (firstList.get(firstListIndex).compareTo(secondList.get(secondListIndex)) < 0) {
                newList.add(secondList.get(secondListIndex));
                secondListIndex++;
            } else {
                newList.add(firstList.get(firstListIndex));
                firstListIndex++;
            }
        }

        if (firstListIndex == firstList.size()) {
            newList.addAll(secondList.subList(secondListIndex, secondList.size()));
        } else {
            newList.addAll(firstList.subList(firstListIndex, firstList.size()));
        }

        return newList;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) {

        LinkedList<T> newList = new LinkedList<>();
        if (inputList.size() > 0) {
            newList.add(inputList.get(0));
        }
        for (int i = 1; i < inputList.size(); i++) {
            newList.add(inputList.get(i));
            newList.addAll(inputList.subList(0, i));
        }

        return newList;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) {

        HashSet<T> firstSet = new HashSet<>(firstList);
        HashSet<T> secondSet = new HashSet<>(secondList);

        return firstSet.equals(secondSet);
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) {
        ArrayDeque<T> deque = new ArrayDeque<>(inputList);

        if (deque.isEmpty()) {
            return new ArrayList<>();
        }

        if (n < 0) {
            while (n != 0) {
                T elem = deque.pollFirst();
                deque.addLast(elem);
                n++;
            }
        } else {
            while (n != 0) {
                T elem = deque.pollLast();
                deque.addFirst(elem);
                n--;
            }
        }
        return new ArrayList<>(deque);
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(@NonNull List<String> inputList, @NonNull String a,
                                        @NonNull String b) {

        if (a == null || b == null) throw new NullPointerException();

        LinkedList<String> arrayList = new LinkedList<>();
        for (String word : inputList) {
            if (word == a) {
                arrayList.add(b);
            } else {
                arrayList.add(word);
            }
        }

        return arrayList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */

    class Task {

        TreeSet<Student> students;
        HashSet<StudentsGroup> groups;

        {
            initStudents();

            for (Student student : students) {
                System.out.println(student.toString());
            }

            for (StudentsGroup group : groups) {
                System.out.printf("Group: %d\n", group.getGroupNumber());
                group.calculateGroupAverages();
                Student bestStudent = group.findBestStudent();
                System.out.printf("The best student of group %d: %s\n", group.getGroupNumber(),
                        bestStudent.toString());
            }

            System.out.printf("The youngest student is: \n%s\n", findYoungestStudent().toString());
            System.out.printf("The eldest students is: \n%s\n", findEldestStudent().toString());

        }

        private void initStudents() {

            ArrayList<Student> arrayStudents= new ArrayList<>();

            StudentsGroup groupA = new StudentsGroup(2002);
            StudentsGroup groupB = new StudentsGroup(1902);
            groups = new HashSet<>(Arrays.asList(groupA, groupB));

            Student student1A = new Student("Vlad", "Popov", "Ivanovich",
                    2003, 1, groupA,
                    new HashMap<String, Integer>() {{
                        put("Biology", 4);
                        put("English", 5);
                        put("Physics", 5);
                        put("History", 5);
                        put("Informatics", 5); }});

            Student student2A = new Student("Georgy", "Georgiev", "Vasilevich",
                    2002, 1, groupA,
                    new HashMap<String, Integer>() {{
                        put("Biology", 4);
                        put("English", 5);
                        put("Physics", 3);
                        put("History", 2);
                        put("Informatics", 5); }}
            );

            groupA.addStudents(student1A, student2A);

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

            students = new TreeSet<>(Arrays.asList(student1A, student2A, student1B));

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
    }

    class StudentsGroup {

        private int groupNumber;
        private SortedSet<Student> students;
        private HashMap<String, Float> groupSubjectsAverage;

        public StudentsGroup(int groupNumber) {
            this.groupNumber = groupNumber;
            students = new TreeSet<>();
            groupSubjectsAverage = new HashMap<>();
        }

        public void calculateGroupAverages() {

            HashMap<String, Integer> subjectMarksSum = new HashMap<>();
            for(Student student: students) {
                for (Map.Entry<String, Integer> subjectMarkMap : student.getSubjectMarkMap().entrySet()) {

                    int mark = subjectMarkMap.getValue();
                    String subject = subjectMarkMap.getKey();

                    if (subjectMarksSum.containsKey(subject)) {
                        int newValue = subjectMarksSum.get(subject) + mark;
                        subjectMarksSum.put(subject, newValue);
                    } else {
                        subjectMarksSum.put(subject, mark);
                    }
                }
            }

            for (Map.Entry<String, Integer> subjectMarkSumMap : subjectMarksSum.entrySet()) {
                groupSubjectsAverage.put(subjectMarkSumMap.getKey(),
                        (float) subjectMarkSumMap.getValue() / students.size());
            }

            displayAverages();
        }

        public void displayAverages() {
            for (Map.Entry<String, Float> subjectsAveragesMap : groupSubjectsAverage.entrySet()) {
                System.out.printf("%s: %.2f\n", subjectsAveragesMap.getKey(), subjectsAveragesMap.getValue());
            }
        }

        public void addStudents(Student... students) {
            this.students.addAll(Arrays.asList(students));
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

    class Student extends Person implements Comparable<Student> {

        private int courseNumber;
        private StudentsGroup group;



        private HashMap<String, Integer> subjectMarkMap;

        public Student(String name, String surname, String patronymic,
                       int birthdayYear, int courseNumber,
                       StudentsGroup group, HashMap<String, Integer> subjectMarkMap) {

            super(name, surname, patronymic, birthdayYear);
            this.courseNumber = courseNumber;
            this.group = group;
            this.subjectMarkMap = subjectMarkMap;
        }


        public HashMap<String, Integer> getSubjectMarkMap() {
            return subjectMarkMap;
        }

        public float getAverage() {

            int sum = 0;
            for (Integer point : subjectMarkMap.values()) {
                sum += point;
            }

            return (float) sum / subjectMarkMap.size();

        }

        public int getPointByGivenSubject(String subject) {
            return subjectMarkMap.get(subject);
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

    abstract class Person {

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

            int resultForSurname = this.surname.compareTo(person.surname);

            if (resultForSurname > 0) {
                return 1;

            } else if (resultForSurname == 0) {
                int resultForName = this.name.compareTo(person.name);

                if (resultForName > 0) {
                    return 1;

                } else if (resultForName == 0) {
                    int resultForPatronymic = this.name.compareTo(person.patronymic);
                    return Integer.compare(resultForPatronymic, 0);

                } else {
                    return -1;
                }
            } else {
                return -1;
            }
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
    }
}
