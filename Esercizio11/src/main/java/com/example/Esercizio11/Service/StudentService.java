package com.example.Esercizio11.Service;

import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void updateIsWorking(Long id, boolean isWorking) {
        Student student = studentRepository.getById(id);
        student.setWorking(isWorking);
        studentRepository.save(student);
    }

    public Boolean deleteStudent(long id) {
        Boolean studentToBeDeleted = studentRepository.existsById(id);
        if (studentToBeDeleted) {
            studentRepository.deleteById(id);
        }
        return studentToBeDeleted;
    }
}
