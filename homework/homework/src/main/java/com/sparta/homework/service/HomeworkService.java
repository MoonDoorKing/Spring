package com.sparta.homework.service;

import com.sparta.homework.domain.Homework;
import com.sparta.homework.domain.HomeworkRepository;
import com.sparta.homework.domain.HomeworkRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Transactional
    public Long update(Long id, String password , HomeworkRequestDto requestDto) {
        Homework homework = homeworkRepository.findByIdAndPassword(id, password).orElseThrow(() -> new NullPointerException("ID값이나 비밀번호가 틀립니다."));

        homework.update(requestDto);

        return homework.getId();
    }
}
