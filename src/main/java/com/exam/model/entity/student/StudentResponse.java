package com.exam.model.entity.student;

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
@Table(name = "tbl_students_responses")
public class StudentResponse {
    @Id
    @Column(name="students_responses_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentResponseId;
    @Column(name="question_id")
    private Long questionId;
    @Column(name="response")
    private String response;
    @Column(name="score_response")
    private Double scoreResponse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_exam_id" )
    @JsonBackReference(value = "StudentExam-StudentResponse")
    private StudentExam studentExam;
}
