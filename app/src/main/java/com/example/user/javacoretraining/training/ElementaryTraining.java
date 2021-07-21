package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        return (double)(firstValue + secondValue) / 2;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        firstValue *= 2;
        secondValue -= 3;
        thirdValue *= thirdValue;
        return firstValue + secondValue + thirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        value = (value > 3) ? (value + 10) : (value - 10);
        return value;
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) {

        // Сперва функция находит длину числа
        // затем пробегает по всем цифрам числа с конца и прибавляет
        // их к newValue, предварительно умножив на соответствующий
        // разряд числа - первую цифру на наивысший разряд числа,
        // а вторую - на десятки. Последнюю цифру - на единицу

        int valueLength = getValueLength(value);

        if (valueLength > 5 || valueLength < 2) {
            return value;
        }

        int newValue = 0;

        int currentPosition = 1;

        // отвечает за разрядность
        int decimal = getMaxDecimal(valueLength);

        newValue += (value % 10) * decimal;
        value /= 10;
        decimal = 10;
        currentPosition++;

        // Прибавляет все цифры между первой и последней.
        while (currentPosition != valueLength) {
            currentPosition++;
            newValue += (value % 10) * decimal;
            decimal *= 10;
            value /= 10;
        }

        newValue += value % 10;

        return newValue;
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {

        /*
         * Сперва функция находит длину числа
         * Затем пробегает по числу слева направо
         * Если текущая цифра нечетная, то прибавляем
         * эту цифру в соответствующем разряде.
         *
         */
        int newValue = 0;
        int valueLength = getValueLength(value);

        if (valueLength < 2 || valueLength > 5) {
            return value;
        }

        // Отвечает за разрядность
        int decimal = getMaxDecimal(valueLength);

        do {
            int nextDigit = value / decimal;
            if (nextDigit % 2 == 1) {
                newValue += nextDigit * decimal;
            }
            value %= decimal;
            decimal /= 10;
        } while (value != 0);

        return newValue;
    }

    private int getValueLength(int value) {

        int valueSize = 0;
        do {
            value /= 10;
            valueSize++;
        } while (value != 0);

        return valueSize;
    }

    private int getMaxDecimal(int valueLength) {

        int decimal = 1;
        for (int i = 1; i < valueLength; i++) {
            decimal *= 10;
        }
        return decimal;
    }
}
