package com.sparta.week01.prac;

public class Prac {
    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("아아");
        course.setDays(12);
        course.setTutor("남병관");
        System.out.println(course.getTitle());
        System.out.println(course.getDays());
    }
}
