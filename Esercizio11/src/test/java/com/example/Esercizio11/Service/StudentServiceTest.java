package com.example.Esercizio11.Service;

import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
}
