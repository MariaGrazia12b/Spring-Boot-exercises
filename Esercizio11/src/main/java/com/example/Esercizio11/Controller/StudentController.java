package com.example.Esercizio11.Controller;

import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import com.example.Esercizio11.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public @ResponseBody Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/retrieve-student")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @PatchMapping("/{id}")
    public void updateIsWorking(@PathVariable Long id, @RequestParam boolean working) {
        studentService.updateIsWorking(id, working);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }


}
