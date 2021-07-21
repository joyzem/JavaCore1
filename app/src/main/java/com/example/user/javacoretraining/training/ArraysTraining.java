package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */
public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {

        for (int i = 0; i < valuesArray.length; i++) {
            for (int j = i + 1; j < valuesArray.length; j++) {
                if (valuesArray[i] > valuesArray[j]) {
                    int temp = valuesArray[i];
                    valuesArray[i] = valuesArray[j];
                    valuesArray[j] = temp;
                }
            }
        }
        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        int max = (values.length == 0) ? 0 : values[0];
        for (int num : values) {
            max = (num > max) ? num : max;
        }
        return max;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[array.length - i - 1] = array[i];
        }
        return reversedArray;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {
        if (numbersCount < 1) {
            return new int[]{};
        }
        if (numbersCount == 1) {
            return new int[]{1};
        }

        int[] fibonacciArray = new int[numbersCount];

        fibonacciArray[0] = 1;
        fibonacciArray[1] = 1;
        for (int i = 2; i < numbersCount; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray;
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {

        int[] sortedArray = sort(array);

        if (array.length == 0) {
            return 0;
        }

        int previousDigit = array[0];
        int maxCount = 1;
        int currentCount = maxCount;

        for (int i = 1; i < array.length; i++) {

            if (array[i] != previousDigit) {
                currentCount = 1;
            } else {
                currentCount++;
            }

            maxCount = (currentCount > maxCount) ? currentCount : maxCount;
            previousDigit = array[i];
        }

        return maxCount;
    }
}
