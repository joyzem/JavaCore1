/*
 @author Rodion Gazizov
 */

package com.example.user.javacoretraining.javaPart2;

/**
 * First task
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
public class Task1 {

    public static void main(String[] args) {
        Printing printer = () -> System.out.println("I love Java");
        repeatTask(10, printer);
    }

    /**
     * This method runs runnable task certain amount of times.
     * @param times - amount of repeats
     * @param task - runnable task - lambda-expression
     */
    public static void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }

}

/**
 * This is a functionality interface for implementing
 * lambda-expression
 */
interface Printing extends Runnable {
    @Override
    void run();
}
