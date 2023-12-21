package com.exam.model.entity.exam;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_questions")
public class Question {
    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(name="question_description")
    private String questionDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exam_id")
    @JsonBackReference(value = "Exam-Question")
    private Exam exam;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Question-Answer")
    List<Answer> answers = new ArrayList<>();


}
