package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonRepository;
import com.example.demo.domain.PersonRequestDto;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {

        Person person = new Person(requestDto);

        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deleteCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        personRepository.deleteById(id);
        return id;
    }
}
