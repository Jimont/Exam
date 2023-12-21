package com.exam.model.entity.student;

import com.exam.model.entity.exam.Exam;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_studen_exam")
public class StudentExam {
    @Id
    @Column(name="student_exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentExamId;
    @Column(name="exam_date")
    private LocalDateTime examDate;
    @Column(name="calification")
    private Double calification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    @JsonBackReference(value = "Exam-StudentExam")
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "Student-StudentExam")
    private Student student;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentExam", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "StudentExam-StudentResponse")
    List<StudentResponse> studentsResponses = new ArrayList<>();
}
