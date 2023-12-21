package com.exam.model.dto.exam;

import com.exam.model.entity.exam.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AnswerDto {
    @JsonProperty("identification_letter")
    private String identificationLetter;
    @JsonProperty("answer_description")
    private String answerDescription;
    @JsonProperty("score_answer")
    private Double scoreAnswer;
    private Question question;
    @JsonProperty("question_id")
    private void unpackNested(Long question_id) {
        this.question = new Question();
        question.setQuestionId(question_id);
    }
}
