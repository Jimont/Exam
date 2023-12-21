package com.exam.model.entity.exam;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_answers")
public class Answer {

    @Id
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    @Column(name="identification_letter")
    private String identificationLetter;
    @Column(name="answer_description")
    private String answerDescription;
    @Column(name="score_answer")
    private Double scoreAnswer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonBackReference(value = "Question-Answer")
    private Question question;
}
