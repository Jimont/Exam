package com.exam.model.dto.exam;

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
public class ExamDto {
    @JsonProperty("exam_name")
    private String examName;
    @JsonProperty("exam_date")
    private LocalDateTime examDate;
    @JsonProperty("time_zone")
    private String timeZone;
}
