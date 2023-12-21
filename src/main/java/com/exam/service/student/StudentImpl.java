package com.exam.service.student;

import com.exam.commons.MapperUtils;
import com.exam.exception.NotFoundException;
import com.exam.model.dao.exam.AnswerDao;
import com.exam.model.dao.exam.ExamDao;
import com.exam.model.dao.student.StudentDao;
import com.exam.model.dao.student.StudentExamDao;
import com.exam.model.dao.student.StudentResponseDao;
import com.exam.model.dto.student.ExamAssignmentDto;
import com.exam.model.dto.student.StudentDto;
import com.exam.model.dto.student.StudentResponseDto;
import com.exam.model.entity.exam.Answer;
import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.student.Student;
import com.exam.model.entity.student.StudentExam;
import com.exam.model.entity.student.StudentResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class StudentImpl implements IStudentService{
    private final StudentExamDao studentExamDao;
    private final StudentDao studentDao;
    private final ExamDao examDao;
    private final AnswerDao answerDao;

    private final String message = "Resource not found please validate";

    private final StudentResponseDao studentResponseDao;
    private final MapperUtils mapper;

    public StudentImpl(StudentExamDao studentExamDao,
                       StudentDao studentDao,
                       ExamDao examDao,
                       AnswerDao answerDao,
                       StudentResponseDao studentResponseDao,
                       MapperUtils mapper) {
        this.studentExamDao = studentExamDao;
        this.studentDao = studentDao;
        this.examDao = examDao;
        this.answerDao = answerDao;
        this.studentResponseDao = studentResponseDao;
        this.mapper = mapper;
    }
    @Transactional
    @Override
    public Student saveStudent(StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
        return studentDao.save(student);
    }
    @Transactional
    @Override
    public StudentExam examAssignment(ExamAssignmentDto examAssignmentDto) throws NotFoundException {
        Exam exam = examDao.findById(examAssignmentDto.getExam().getExamId()).orElse(null);
        Student student = studentDao.findById(examAssignmentDto.getStudent().getStudentId()).orElse(null);
        if ((exam==null) || (student==null)){
            throw new NotFoundException(message);
        }
        StudentExam studentExam = mapper.map(examAssignmentDto, StudentExam.class);
        studentExam.setExamDate(timeZoneConverter(exam.getTimeZone(), exam.getExamDate(), student.getTimeZone()));
        return studentExamDao.save(studentExam);
    }
    @Transactional
    @Override
    public StudentResponse saveResponseStudent(StudentResponseDto studentResponseDto) throws NotFoundException {
        StudentResponse studentResponse = mapper.map(studentResponseDto, StudentResponse.class);
        Answer answer = answerDao.getScoreAnswer(studentResponseDto.getQuestionId(), studentResponseDto.getResponse());
        studentResponse.setScoreResponse(answer.getScoreAnswer());
        if (answer==null){
            throw new NotFoundException(message);
        }
        studentResponse.setScoreResponse(answer.getScoreAnswer());
        StudentResponse studentResponseSave = studentResponseDao.save(studentResponse);
        calification(studentResponseDto);
        return studentResponseSave;
    }

    private LocalDateTime timeZoneConverter(String znExam, LocalDateTime hourExam, String znStudent){
        LocalDateTime localDateTime = hourExam;
        ZoneId zoneExam = ZoneId.of(znExam);
        ZonedDateTime examZonedDateTime = localDateTime.atZone(zoneExam);
        ZoneId zoneStudent = ZoneId.of(znStudent);
        ZonedDateTime newDateTime = examZonedDateTime.withZoneSameInstant(zoneStudent);
        return newDateTime.toLocalDateTime();
    }

    private void calification(StudentResponseDto studentResponseDto) throws NotFoundException {
        Double respCalification = studentResponseDao.calification(studentResponseDto.getStudentExam().getStudentExamId());
        StudentExam studentExamResp = studentExamDao.findById(studentResponseDto.getStudentExam().getStudentExamId()).orElse(null);
        if (respCalification==null || studentExamResp==null){
            throw new NotFoundException(message);
        }
        studentExamResp.setCalification(respCalification);
        studentExamDao.save(studentExamResp);
    }

}
