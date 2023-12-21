package com.exam.controller;

import com.exam.exception.NotFoundException;
import com.exam.model.dto.student.ExamAssignmentDto;
import com.exam.model.dto.student.StudentDto;
import com.exam.model.dto.student.StudentResponseDto;
import com.exam.model.entity.student.Student;
import com.exam.model.entity.student.StudentExam;
import com.exam.model.entity.student.StudentResponse;
import com.exam.service.student.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createdExam(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.saveStudent(studentDto), HttpStatus.CREATED);
    }

    @PostMapping("/Assignment_Exam")
    public ResponseEntity<StudentExam> AssignmentExam(@RequestBody ExamAssignmentDto examAssignmentDto) throws NotFoundException {
        return new ResponseEntity<>(studentService.examAssignment(examAssignmentDto), HttpStatus.CREATED);
    }

    @PostMapping("/student_response")
    public ResponseEntity<StudentResponse> AssignmentExam(@RequestBody StudentResponseDto studentResponseDto) throws NotFoundException{
        return new ResponseEntity<>(studentService.saveResponseStudent(studentResponseDto), HttpStatus.CREATED);
    }
}
