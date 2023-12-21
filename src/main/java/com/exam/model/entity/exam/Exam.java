package com.exam.model.entity.exam;

import com.exam.model.entity.student.Student;
import com.exam.model.entity.student.StudentExam;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_exams")
public class Exam {
    @Id
    @Column(name="exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    @Column(name="exam_name")
    private String examName;
    @Column(name="exam_date")
    private LocalDateTime examDate;
    @Column(name="time_zone")
    private String timeZone;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Exam-Question")
    List<Question> questions = new ArrayList<>();



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Exam-StudentExam")
    List<StudentExam> studentsExam = new ArrayList<>();
}
