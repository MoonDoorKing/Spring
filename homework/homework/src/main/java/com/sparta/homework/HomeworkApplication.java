package com.sparta.homework;

import com.sparta.homework.domain.Homework;
import com.sparta.homework.domain.HomeworkRepository;
import com.sparta.homework.service.HomeworkService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(HomeworkRepository homeworkRepository, HomeworkService homeworkService) {
		return (args) -> {
			homeworkRepository.save(new Homework("문철현", "아아", "아아아", "123"));

			System.out.println("데이터 인쇄");
			List<Homework> homeworkList = homeworkRepository.findAll();
			for (int i = 0; i < homeworkList.size(); i++) {
				Homework homework = homeworkList.get(i);
				System.out.println(homework.getId());
				System.out.println(homework.getName());
				System.out.println(homework.getTitle());
				System.out.println(homework.getComment());
				System.out.println(homework.getPassword());
			}
		};
	}
}
