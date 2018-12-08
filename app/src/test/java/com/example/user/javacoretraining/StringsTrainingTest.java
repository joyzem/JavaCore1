package com.example.user.javacoretraining;

import com.example.user.javacoretraining.training.StringsTraining;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTrainingTest {

    private static StringsTraining stringsTraining;

    @BeforeClass
    public static void init() {
        stringsTraining = new StringsTraining();
    }

    @Test
    public void capitalReverse_isValidEng() {
        String text = "Hello World_123";
        String verificationText = "hELLO wORLD_123";
        String capitalReversedText = stringsTraining.capitalReverse(text);
        assertEquals(capitalReversedText, verificationText);
    }

    @Test
    public void capitalReverse_isValidRus() {
        String text = "Здравствуй, Мир!";
        String verificationText = "зДРАВСТВУЙ, мИР!";
        String capitalReversedText = stringsTraining.capitalReverse(text);
        assertEquals(capitalReversedText, verificationText);
    }
}
