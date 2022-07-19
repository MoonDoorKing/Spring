package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonRepository;
import com.example.demo.domain.PersonRequestDto;
import com.example.demo.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
		return (args) -> {
			personRepository.save(new Person("문철현", 28, "무직", "대구"));

			System.out.println("데이터 인쇄");
			List<Person> personList = personRepository.findAll();
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println(person.getId());
				System.out.println(person.getName());
				System.out.println(person.getAge());
				System.out.println(person.getJob());
				System.out.println(person.getAddress());
			}

			PersonRequestDto requestDto = new PersonRequestDto("철현", 29, "웹프로그래머", "대구");
			personService.update(1L, requestDto);
			personList = personRepository.findAll();
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println(person.getId());
				System.out.println(person.getName());
				System.out.println(person.getAge());
				System.out.println(person.getJob());
				System.out.println(person.getAddress());
			}
		};
	}
}
