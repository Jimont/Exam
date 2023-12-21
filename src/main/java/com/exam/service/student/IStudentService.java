package com.exam.service.student;

import com.exam.exception.NotFoundException;
import com.exam.model.dto.student.ExamAssignmentDto;
import com.exam.model.dto.student.StudentDto;
import com.exam.model.dto.student.StudentResponseDto;
import com.exam.model.entity.student.Student;
import com.exam.model.entity.student.StudentExam;
import com.exam.model.entity.student.StudentResponse;

public interface IStudentService {
    Student saveStudent(StudentDto studentDto);

    StudentExam examAssignment(ExamAssignmentDto examAssignmentDto) throws NotFoundException;

    StudentResponse saveResponseStudent(StudentResponseDto studentResponseDto) throws NotFoundException;
}
