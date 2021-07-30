package com.example.user.javacoretraining.collections.practice_task;

public class Subject {

    private String subjectName;
    private float mark;

    public Subject(String subjectName, float mark) {
        this.subjectName = subjectName;
        this.mark = mark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return subjectName.toString() + ": " + mark;
    }
}
