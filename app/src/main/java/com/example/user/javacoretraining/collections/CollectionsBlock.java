package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        List<T> newList = new LinkedList<>();
        int minSize = Math.min(firstList.size(), secondList.size());
        int firstListIndex = 0;
        int secondListIndex = 0;

        while (firstListIndex < minSize && secondListIndex < minSize) {
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
        LinkedList<String> linkedList = new LinkedList<>();
        for (String word : inputList) {
            if (word.equals(a)) {
                linkedList.add(b);
            } else {
                linkedList.add(word);
            }
        }
        return linkedList;
    }
}
