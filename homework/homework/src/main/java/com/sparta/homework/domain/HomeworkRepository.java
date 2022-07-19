package com.sparta.homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
        List<Homework> findAllByOrderByModifiedAtDesc();//수정된 날짜 순으로 내림차순으로 정렬

        Optional<Homework> findByIdAndPassword(Long id, String password);



}
