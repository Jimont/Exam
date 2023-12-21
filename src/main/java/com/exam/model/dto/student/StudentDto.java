package com.exam.model.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StudentDto {
    @JsonProperty("document_id")
    private Long documentId;
    @JsonProperty("full_name")
    private String fullName;
    private Integer age;
    private String city;
    @JsonProperty("time_zone")
    private String timeZone;
}
