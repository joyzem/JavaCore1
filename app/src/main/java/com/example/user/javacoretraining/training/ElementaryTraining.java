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

        int valueLength = 0;
        int valueCopy = value;

        do {
            valueCopy /= 10;
            valueLength++;
        } while (valueCopy > 0);

        if (valueLength > 5 || valueLength < 2) {
            return value;
        }

        int newValue = 0;

        int currentPosition = 1;

        // отвечает за разрядность
        int decimal = 1;

        for (int i = 1; i < valueLength; i++) {
            decimal *= 10;
        }

        valueCopy = value;
        newValue += (valueCopy % 10) * decimal;
        valueCopy /= 10;
        decimal = 10;
        currentPosition++;

        // Прибавляет все цифры между первой и последней.
        while (currentPosition != valueLength) {
            currentPosition++;
            newValue += (valueCopy % 10) * decimal;
            decimal *= 10;
            valueCopy /= 10;
        }

        newValue += valueCopy % 10;

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
        int valueSize = 0;
        int valueCopy = value;

        do {
            valueCopy /= 10;
            valueSize++;
        } while (valueCopy != 0);

        if (valueSize < 2 || valueSize > 5) {
            return value;
        }

        // Отвечает за разрядность
        int decimal = 1;
        for (int i = 1; i < valueSize; i++) {
            decimal *= 10;
        }

        valueCopy = value;
        do {
            int nextDigit = valueCopy / decimal;
            if (nextDigit % 2 == 1) {
                newValue += nextDigit * decimal;
            }
            valueCopy %= decimal;
            decimal /= 10;
        } while (valueCopy != 0);

        return newValue;
    }
}
