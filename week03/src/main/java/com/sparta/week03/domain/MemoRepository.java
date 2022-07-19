package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;



public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end); //수정된 날짜 순으로 내림차순으로 정렬
}
