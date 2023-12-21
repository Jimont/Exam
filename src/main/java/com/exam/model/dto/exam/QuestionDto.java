package com.exam.model.dto.exam;

import com.exam.model.entity.exam.Exam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class QuestionDto {

    @JsonProperty("question_description")
    private String questionDescription;
    private Exam exam;
    @JsonProperty("exam_id")
    private void unpackNested(Long exam_id) {
        this.exam = new Exam();
        exam.setExamId(exam_id);
    }

}
