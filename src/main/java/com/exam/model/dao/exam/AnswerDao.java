package com.exam.model.dao.exam;

import com.exam.model.entity.exam.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao extends CrudRepository<Answer, Long> {
    @Query("select a from Answer a where a.question.questionId = ?1 and a.identificationLetter = ?2")
    Answer getScoreAnswer(Long questionId, String identificationLetter);
}
