package com.sparta.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class HomeworkRequestDto {
    private final String name;
    private final String title;
    private final String comment;
    private final String password;
}
