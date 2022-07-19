package com.sparta.homework.controller;

import com.sparta.homework.domain.Homework;
import com.sparta.homework.domain.HomeworkRepository;
import com.sparta.homework.domain.HomeworkRequestDto;
import com.sparta.homework.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HomeworkController {

    private final HomeworkRepository homeworkRepository;

    private final HomeworkService homeworkService;

    @PostMapping("/api/homeworks")
    public Homework createHomework(@RequestBody HomeworkRequestDto requestDto) {
        Homework homework = new Homework(requestDto);

        return homeworkRepository.save(homework);
    }

    @GetMapping("/api/homeworks")
    public List<Homework> getHomeworks() {
        return homeworkRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/homeworks/{id}")
    public Optional<Homework> getHomeworks(@PathVariable Long id) {
        return homeworkRepository.findById(id);
    }

    @PutMapping("/api/homeworks/{id}")
    public Long updateHomework(@PathVariable("id") Long id, @RequestBody HomeworkRequestDto requestDto) {
        return homeworkService.update(id, requestDto.getPassword(), requestDto);
    }

    @DeleteMapping("/api/homeworks/{id}")
    public Long deleteHomework(@PathVariable("id") Long id, @RequestBody HomeworkRequestDto requestDto ) {
        Optional<Homework> homework = homeworkRepository.findById(id);
        long a = 404;
        if(homework.isPresent())
            if(homework.get().getPassword().equals(requestDto.getPassword()))
            {
                homeworkRepository.deleteById(id);
                return id;
            }
        return a;
    }
}
