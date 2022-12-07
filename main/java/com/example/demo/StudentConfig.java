package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository
    ) {
        return args -> {
            Student maria = new Student(
                    1L,
                    "Maria",
                    "maria.thomasen@gmail.com",
                    LocalDate.of(2021, Month.DECEMBER, 5)

            );

            Student alex =  new Student(
                    2L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1989, Month.JANUARY, 5)

            );

            Student sarah = new Student(
                    3L,
                    "Sarah",
                    "sarah.gilsen@gmail.com",
                    LocalDate.of(1989, Month.MAY, 5)

            );

            studentRepository.saveAll(List.of(maria, alex, sarah));

        };

    }


}
