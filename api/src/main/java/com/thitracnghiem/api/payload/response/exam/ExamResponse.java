package com.thitracnghiem.api.payload.response.exam;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExamResponse {
    private boolean status;
    private String message;
    private Exam exam;

}
