package com.example.demo.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
}
