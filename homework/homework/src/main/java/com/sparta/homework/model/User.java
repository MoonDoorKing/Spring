package com.sparta.homework.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


}
