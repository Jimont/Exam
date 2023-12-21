package com.exam.model.dto.student;

import com.exam.model.entity.exam.Exam;
import com.exam.model.entity.student.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ExamAssignmentDto {
    @JsonProperty("exam_date")
    private LocalDateTime examDate;
    private Exam exam;
    @JsonProperty("exam_id")
    private void unpackNested(Long exam_id) {
        this.exam = new Exam();
        exam.setExamId(exam_id);
    }
    private Student student;
    @JsonProperty("student_id")
    private void unpackNested2(Long student_id) {
        this.student = new Student();
        student.setStudentId(student_id);
    }


}
