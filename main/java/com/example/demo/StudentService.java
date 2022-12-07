package com.example.demo;


import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;


public class StudentService {


    public List<Student> getStudents() {

        return List.of(new Student(1L, "Mariam", "maria.thomasen@gmail.com", LocalDate.of(2000, Month.JULY, 12)), 33)


    }
}
