package com.sparta.week01.prac;

public class Tutor {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBio() {
        return bio;
    }

    public void setBio(int bio) {
        this.bio = bio;
    }
    // name 과 bio 를 받는 생성자
    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }
    // 기본 생성자
    public Tutor() {

    }

    private String name;
    private int bio;


}
