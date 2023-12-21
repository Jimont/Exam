package com.exam.controller;

import com.exam.exception.NotFoundException;
import com.exam.model.dto.exam.AnswerDto;
import com.exam.model.dto.exam.ExamDto;
import com.exam.model.dto.exam.QuestionDto;
import com.exam.model.entity.exam.Answer;
import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.exam.Question;
import com.exam.service.exam.IExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExamController {
    private final IExamService examService;

    public ExamController(IExamService iExamService) {
        this.examService = iExamService;
    }

    @PostMapping("/exam")
    public ResponseEntity<Exam> createdExam(@RequestBody ExamDto examDto){
        return new ResponseEntity<>(examService.saveExam(examDto), HttpStatus.CREATED);
    }

    @PostMapping("/question")
    public ResponseEntity<Question> createdQuestion(@RequestBody QuestionDto questionDto){
        return new ResponseEntity<>(examService.saveQuestion(questionDto), HttpStatus.CREATED);
    }

    @PostMapping("/answers")
    public List<Answer> createdAnswer(@RequestBody List<AnswerDto> answerDtoList){
        return examService.saveAnswer(answerDtoList);
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long examId) throws NotFoundException {
        return new ResponseEntity<>(examService.faindExamById(examId), HttpStatus.OK);
    }

}
