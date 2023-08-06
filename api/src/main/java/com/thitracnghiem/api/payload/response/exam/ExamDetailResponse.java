package com.thitracnghiem.api.payload.response.exam;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExamDetailResponse {
    private boolean status;
    private String message;
    private ExamDetail examDetail;
}
