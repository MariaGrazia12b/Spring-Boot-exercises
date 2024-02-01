package com.example.Esercizio11.Service;

import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class StudentServiceTest
{
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testUpdateIsWorking() {
        //Mock
        Student student = new Student();
        student.setId(1L);
        student.setWorking(false);

        when(studentRepository.getById(1L)).thenReturn(student);

        //Test
        studentService.updateIsWorking(1L, true);

        verify(studentRepository, times(1)).save(student);
        assertTrue(student.isWorking());
    }

    @Test
    public void testGetAll() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student(3L, "Maria", "Bella", true);
        studentList.add(student);
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> result = studentService.getAllStudent();
        Assert.assertEquals(result.get(0).getName(), "Maria");
    }

    @Test
    public void testDeleteStud() {
        when(studentRepository.existsById(any(Long.class))).thenReturn(true);
        Boolean result = studentService.deleteStudent(any(Long.class));
        Assert.assertEquals(true, result);
    }
}
