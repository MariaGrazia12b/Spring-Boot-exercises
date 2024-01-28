package com.example.Esercizio11.Service;

import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void updateIsWorking(Long id, boolean isWorking) {
        Student student = studentRepository.getById(id);
        student.setWorking(isWorking);
        studentRepository.save(student);
    }
}
