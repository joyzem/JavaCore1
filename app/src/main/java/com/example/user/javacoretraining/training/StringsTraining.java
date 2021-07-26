package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        //TODO: implement it
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 1) {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {

        int[] result = new int[text.length()];

        int lastIndex = 0;
        if (text.length() > 0) {
            char lastChar = text.charAt(text.length() - 1);
            for (int i = 0; i < text.length() - 1; i++) {
                if (text.charAt(i) == lastChar) {
                    result[lastIndex] = i;
                    lastIndex++;
                }
            }
        }

        if (lastIndex == 0) {
            return new int[] {};
        }

        int[] trimmedResult = new int[lastIndex] ;
        if (lastIndex >= 0) System.arraycopy(result, 0, trimmedResult, 0, lastIndex);
        return trimmedResult;
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {

        int result = 0;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                result++;
            }
        }

        return result;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {

        StringBuilder newString = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            char nextChar = text.charAt(i);
            switch(nextChar) {
                case '0':
                    newString.append("zero");
                    break;
                case '1':
                    newString.append("one");
                    break;
                case '2':
                    newString.append("two");
                    break;
                case '3':
                    newString.append("three");
                    break;
                case '4':
                    newString.append("four");
                    break;
                case '5':
                    newString.append("five");
                    break;
                case '6':
                    newString.append("six");
                    break;
                case '7':
                    newString.append("seven");
                    break;
                case '8':
                    newString.append("eight");
                    break;
                case '9':
                    newString.append("nine");
                    break;
                default:
                    newString.append(nextChar);
            }
        }

        return newString.toString();
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        StringBuilder newString = new StringBuilder(text);
        for (int i = 0; i < newString.length(); i++) {

            char currentChar = newString.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                newString.setCharAt(i, Character.toLowerCase(currentChar));
            } else {
                newString.setCharAt(i, Character.toUpperCase(currentChar));
            }

        }
        return newString.toString();
    }

}
