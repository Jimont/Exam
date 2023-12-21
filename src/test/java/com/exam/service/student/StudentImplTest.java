package com.exam.service.student;

import com.exam.model.dto.student.StudentDto;
import com.exam.model.entity.student.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentImplTest {
    @MockBean
    private StudentImpl studentImplService;

    private StudentDto studentDto;

    @BeforeEach
    void setUp() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setDocumentId(12345L);
        student.setFullName("Maria Perez");
        student.setAge(20);
        student.setCity("Buenos Aires");
        student.setTimeZone("America/Buenos_Aires");

        studentDto = new StudentDto();
        studentDto.setDocumentId(12345L);
        studentDto.setFullName("Maria Perez");
        studentDto.setAge(20);
        studentDto.setCity("Buenos Aires");
        studentDto.setTimeZone("America/Buenos_Aires");

        Mockito.when(studentImplService.saveStudent(studentDto)).thenReturn(student);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveStudent() {
        Student studentRes = new Student();
        studentRes = studentImplService.saveStudent(studentDto);
        assertEquals("America/Buenos_Aires", studentRes.getTimeZone());
    }

    @Test
    void examAssignment() {
    }

    @Test
    void saveResponseStudent() {
    }
}