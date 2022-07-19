package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonRepository;
import com.example.demo.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));

        person1.update(requestDto);
        return person1.getId();
    }

    @Transactional
    public Long delete(Long id, PersonRequestDto requestDto) {
        Person person1 = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));

        person1.delete(requestDto);
        return person1.getId();
    }
}
