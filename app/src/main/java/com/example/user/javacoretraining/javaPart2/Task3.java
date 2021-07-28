/*
 @author Rodion Gazizov
 */

package com.example.user.javacoretraining.javaPart2;

/**
 * Third task
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
public class Task3 {
}

/**
 * This class represents circle and has diameter field, and implements
 * Shape interface.
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
class Circle implements Shape {

    private float diameter;

    /**
     * Initial constructor
     *
     * @param diameter Diameter of the circle
     */
    public Circle(float diameter) {
        this.diameter = diameter;
    }

    @Override
    public float perimeter() {
        return (float) (2 * Math.PI * diameter / 2);
    }

    @Override
    public float area() {
        return (float) (Math.PI * (diameter / 2) * (diameter / 2));
    }
}

/**
 * This class represents square and has length field, and implements
 * Shape interface.
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
class Square implements Shape {

    private float length;

    /**
     * Initial constructor
     *
     * @param length Square's side length
     */
    public Square(float length) {
        this.length = length;
    }

    @Override
    public float perimeter() {
        return length * 4;
    }

    @Override
    public float area() {
        return length * length;
    }
}

/**
 * This class represents rectangle, has length and width fields,
 * and implements Shape interface.
 *
 * @version 1.0 28 Jul 2021
 * @author Rodion Gazizov
 */
class Rectangle implements Shape {

    private float length;
    private float width;

    /**
     * Initial constructor
     *
     * @param length The rectangle's length
     * @param width The rectangle's width
     */
    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public float perimeter() {
        return length * 2 + width * 2;
    }

    @Override
    public float area() {
        return length * width;
    }
}

interface Shape {

    /**
     * Method for calculating shape's perimeter
     *
     * @return Perimeter of a shape
     */
    float perimeter();

    /**
     * Method for calculating shape's area
     *
     * @return Area of a shape
     */
    float area();
}