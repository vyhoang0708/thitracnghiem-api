package com.thitracnghiem.api.payload.request.exam;

import lombok.Data;

import java.util.List;

@Data
public class ExamDetailRequest {
    private long idExam;
    private List<AddQuestionRequest> addQuestionRequests;
}
