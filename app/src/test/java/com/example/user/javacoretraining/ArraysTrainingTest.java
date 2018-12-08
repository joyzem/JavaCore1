package com.example.user.javacoretraining;

import com.example.user.javacoretraining.training.ArraysTraining;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraysTrainingTest {

    private static ArraysTraining arraysTraining;

    @BeforeClass
    public static void init() {
        arraysTraining = new ArraysTraining();
    }

    @Test
    public void sort_twelveItems() {
        int[] array = {100, 15, 21, 45, 30, 57, 48, 0, -2, 4, 80, -11};
        int[] arraySorted = {-11, -2, 0, 4, 15, 21, 30, 45, 48, 57, 80, 100};
        int[] sortedArrayFunc = arraysTraining.sort(array);
        assertArrayEquals(arraySorted, sortedArrayFunc);
    }

    @Test
    public void sort_zeroItems() {
        int[] array = {};
        int[] arraySorted = {};
        int[] sortedArrayFunc = arraysTraining.sort(array);
        assertArrayEquals(arraySorted, sortedArrayFunc);
    }

    @Test
    public void sort_oneItems() {
        int[] array = {5};
        int[] arraySorted = {5};
        int[] sortedArrayFunc = arraysTraining.sort(array);
        assertArrayEquals(arraySorted, sortedArrayFunc);
    }

    @Test
    public void maxValue_emptyItems() {
        int expectedResultIfValuesIsEmpty = 0;
        int result = arraysTraining.maxValue();
        assertEquals(expectedResultIfValuesIsEmpty, result);
    }

    @Test
    public void maxValue_oneItems() {
        int value = 10;
        int result = arraysTraining.maxValue(value);
        assertEquals(value, result);
    }

    @Test
    public void maxValue_tenItems() {
        int[] values = {-2, 7, 10, -20};
        int maxValue = 10;
        int result = arraysTraining.maxValue(values);
        assertEquals(maxValue, result);
    }
}
