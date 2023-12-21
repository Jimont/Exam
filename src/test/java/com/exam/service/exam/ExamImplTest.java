package com.exam.service.exam;

import com.exam.model.dto.exam.AnswerDto;
import com.exam.model.dto.exam.ExamDto;
import com.exam.model.dto.exam.QuestionDto;
import com.exam.model.entity.exam.Answer;
import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.exam.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExamImplTest {
    @MockBean
    private ExamImpl examImplService;
    private ExamDto examDto;
    private QuestionDto questionDto;
    private List<AnswerDto> answerDtoList;

    @BeforeEach
    void setUp() {
        LocalDateTime datetime = LocalDateTime.now();
        Exam exam = new Exam();
        exam.setExamId(1l);
        exam.setExamName("Matematicas");
        exam.setExamDate(datetime);
        exam.setTimeZone("America/Bogota");

        examDto = new ExamDto();
        examDto.setExamName("Matematicas");
        examDto.setExamDate(datetime);
        examDto.setTimeZone("America/Bogota");

        questionDto = new QuestionDto();
        questionDto.setExam(exam);
        questionDto.setQuestionDescription("¿Cuanto es 2 + 2");

        Question question = new Question();
        question.setQuestionId(1L);
        question.setExam(exam);
        question.setQuestionDescription("¿Cuanto es 2 + 2");

        List<Answer> listAnswer = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setAnswerId(1L);
        answer1.setIdentificationLetter("A");
        answer1.setAnswerDescription("4");
        answer1.setScoreAnswer(50.0);
        answer1.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setAnswerId(2L);
        answer2.setIdentificationLetter("B");
        answer2.setAnswerDescription("10");
        answer2.setScoreAnswer(0.0);
        answer2.setQuestion(question);

        listAnswer.add(answer1);
        listAnswer.add(answer2);

        answerDtoList = new ArrayList<>();
        AnswerDto answerDto1 = new AnswerDto();
        answerDto1.setIdentificationLetter("A");
        answerDto1.setAnswerDescription("4");
        answerDto1.setScoreAnswer(50.0);
        answerDto1.setQuestion(question);

        AnswerDto answerDto2 = new AnswerDto();
        answerDto2.setIdentificationLetter("B");
        answerDto2.setAnswerDescription("10");
        answerDto2.setScoreAnswer(0.0);
        answerDto2.setQuestion(question);

        answerDtoList.add(answerDto1);
        answerDtoList.add(answerDto2);

        Mockito.when(examImplService.saveExam(examDto)).thenReturn(exam);
        Mockito.when(examImplService.saveQuestion(questionDto)).thenReturn(question);
        Mockito.when(examImplService.saveAnswer(answerDtoList)).thenReturn(listAnswer);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveExam() {
        Exam examResp = new Exam();
        examResp = examImplService.saveExam(examDto);
        assertEquals("Matematicas", examResp.getExamName());
    }

    @Test
    void saveQuestion() {
        Question questionResp = new Question();
        questionResp = examImplService.saveQuestion(questionDto);
        assertEquals(1L, questionResp.getQuestionId());
    }

    @Test
    void saveAnswer() {
        List<Answer> listAnswerResp = new ArrayList<>();
        listAnswerResp = examImplService.saveAnswer(answerDtoList);
        assertEquals(2, listAnswerResp.size()) ;
    }

    @Test
    void faindExamById() {
    }
}