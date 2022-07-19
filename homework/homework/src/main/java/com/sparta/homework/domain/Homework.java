package com.sparta.homework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Homework extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    public Homework(String name, String title, String comment, String password)
    {
        this.name = name;
        this.title = title;
        this.comment = comment;
        this.password = password;
    }

    public Homework(HomeworkRequestDto requestDto)
    {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
        this.password = requestDto.getPassword();
    }

    public void update(HomeworkRequestDto requestDto)
    {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
        this.password = requestDto.getPassword();
    }

    public void delete(HomeworkRequestDto requestDto)
    {
        this.name = requestDto.getName()    ;
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
        this.password = requestDto.getPassword();
    }
}
