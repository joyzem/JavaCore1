/*
 @author Rodion Gazizov
 */

package com.example.user.javacoretraining.javaPart2;

/**
 * Second task
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
public class Task2 {

    public static void main(String[] args) {
        Point.moveMultiTimes();
    }
}

/**
 * This class imitates point behaviour
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
class Point {
    /*
     Class has field for coordinates displaying, constructor for
     giving initial value, static method for calculating new
     coordinates value by the given direction, and method
     that imitate route passing.
     */

    /**
     * Current coordinates of the point
     */
    Pair<Integer, Integer> coordinates;

    /**
     * Initial constructor
     *
     * @param x X coordinate of the point
     * @param y Y coordinate of the point
     */
    Point(int x, int y) {
        coordinates = new Pair<>(x, y);
    }

    /**
     * Takes coordinates and direction and returns new
     * coordinates according the given direction
     *
     * @param coordinates Old coordinates
     * @param direction Direction
     * @return New coordinates
     */
    public static Pair<Integer, Integer> getNewCoordinates(
            Pair<Integer, Integer> coordinates, Directions direction) {
        switch (direction) {
            case up:
                return new Pair<>(coordinates.getFirst(),
                        coordinates.getSecond() + 1);
            case down:
                return new Pair<>(coordinates.getFirst(),
                        coordinates.getSecond() - 1);
            case left:
                return new Pair<>(coordinates.getFirst() - 1,
                        coordinates.getSecond());
            default:
                return new Pair<>(coordinates.getFirst() + 1,
                        coordinates.getSecond());
        }
    }

    /**
     * Passes certain route and displays each 'stop'
     */
    public static void moveMultiTimes() {
        Pair<Integer, Integer> location = new Pair<>(0, 0);
        Directions[] route = new Directions[] {
                Directions.up,
                Directions.up,
                Directions.left,
                Directions.down,
                Directions.left,
                Directions.down,
                Directions.down,
                Directions.right,
                Directions.right,
                Directions.down,
                Directions.right
        };

        for (Directions direction : route) {
            location = getNewCoordinates(location, direction);
            System.out.printf("X: %d, Y: %d\n", location.getFirst(), location.getSecond());
        }
    }
}

/**
 * Class for holding two logically related values
 *
 * @param <T> Generic for the first value
 * @param <E> Generic for the second value
 */
class Pair<T, E> {

    /**
     * First value
     */
    private T t;

    /**
     * Second value
     */
    private E e;

    /**
     * Constructor
     *
     * @param t First value
     * @param e Second value
     */
    Pair(T t, E e) {
        this.t = t;
        this.e = e;
    }

    /**
     * @return First value
     */
    public T getFirst() {
        return t;
    }

    /**
     * @return Second value
     */
    public E getSecond() {
        return e;
    }

    /**
     * Setter for the first value
     *
     * @param t The new value of the first value
     */
    public void setFirst(T t) {
        this.t = t;
    }

    /**
     * Setter for the second value
     *
     * @param e The new value of the second value
     */
    public void setSecond(E e) {
        this.e = e;
    }
}

enum Directions {
    up,
    down,
    left,
    right
}