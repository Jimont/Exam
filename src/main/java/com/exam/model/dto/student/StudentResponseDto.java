package com.exam.model.dto.student;

import com.exam.model.entity.student.Student;
import com.exam.model.entity.student.StudentExam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StudentResponseDto {
    @JsonProperty("question_id")
    private Long questionId;
    private String response;
    private StudentExam studentExam;
    @JsonProperty("assignment_exam_Id")
    private void unpackNested(Long assignment_exam_Id) {
        this.studentExam = new StudentExam();
        studentExam.setStudentExamId(assignment_exam_Id);
    }
}
