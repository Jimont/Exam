package com.exam.model.entity.student;

import com.exam.model.entity.exam.Exam;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_students")
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name="document_id")
    private Long documentId;
    @Column(name="full_name")
    private String fullName;
    @Column(name="age")
    private Integer age;
    @Column(name="city")
    private String city;
    @Column(name="time_zone")
    private String timeZone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Student-StudentExam")
    List<StudentExam> studentExam = new ArrayList<>();

}
