package com.exam.service.exam;

import com.exam.commons.MapperUtils;
import com.exam.exception.NotFoundException;
import com.exam.model.dao.exam.AnswerDao;
import com.exam.model.dao.exam.ExamDao;
import com.exam.model.dao.exam.QuestionDao;
import com.exam.model.dto.exam.AnswerDto;
import com.exam.model.dto.exam.ExamDto;
import com.exam.model.dto.exam.QuestionDto;
import com.exam.model.entity.exam.Answer;
import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.exam.Question;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamImpl implements IExamService{
    private final ExamDao examDao;
    private final QuestionDao questionDao;
    private final AnswerDao answerDao;
    private final MapperUtils mapper;

    public ExamImpl(ExamDao examDao, QuestionDao questionDao, AnswerDao answerDao, MapperUtils mapper) {
        this.examDao = examDao;
        this.questionDao = questionDao;
        this.answerDao = answerDao;
        this.mapper = mapper;
    }
    @Transactional
    @Override
    public Exam saveExam(ExamDto examDto) {
        Exam exam = mapper.map(examDto, Exam.class);
        return examDao.save(exam);
    }
    @Transactional
    @Override
    public Question saveQuestion(QuestionDto questionDto) {
        Question question = mapper.map(questionDto, Question.class);
        return questionDao.save(question);
    }
    @Transactional
    @Override
    public List<Answer> saveAnswer(List<AnswerDto> answersDto) {
        List<Answer> answers = new ArrayList<>();
        for (AnswerDto aDto:answersDto){
            Answer answer = mapper.map(aDto, Answer.class);
            answers.add(answerDao.save(answer));
        }
        return answers;
    }
    @Transactional
    @Override
    public Exam faindExamById(Long examId) throws NotFoundException {
        Exam exam = examDao.findById(examId).orElse(null);
        if (exam==null){
            throw new NotFoundException("Resource not found please validate");
        }
        return exam;
    }
}
