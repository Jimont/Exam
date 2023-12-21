package com.exam.service.exam;

import com.exam.exception.NotFoundException;
import com.exam.model.dto.exam.AnswerDto;
import com.exam.model.dto.exam.ExamDto;
import com.exam.model.dto.exam.QuestionDto;
import com.exam.model.entity.exam.Answer;
import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.exam.Question;

import java.util.List;

public interface IExamService {
    Exam saveExam(ExamDto examDto);
    Question saveQuestion(QuestionDto questionDto);

    List<Answer> saveAnswer(List<AnswerDto> answersDto);
    Exam faindExamById(Long examId) throws NotFoundException;
}
