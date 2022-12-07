package com.example.springbootexample;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentbyEmail = studentRepository.findStudentbyEmail(student.getEmail());
        if(studentbyEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentid) {
        boolean studentExist = studentRepository.existsById(studentid);
        if(!studentExist) {
            throw new IllegalStateException("Student mit der ID " + studentid + " existiert nicht!");
        }
        studentRepository.deleteById(studentid);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
         Student student = studentRepository.findById(studentId).
                 orElseThrow(() ->
                         new IllegalStateException("Student mit id " + studentId + "existiert nicht!" ));


         if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
             student.setName(name);
         }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentbyEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }



   



    /*public void findStudentbyEmail(Student student) {
        System.out.println(student);
        Optional<Student> studentbyEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(!studentbyEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
    */







}
