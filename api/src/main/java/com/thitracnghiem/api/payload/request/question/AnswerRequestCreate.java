package com.thitracnghiem.api.payload.request.question;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AnswerRequestCreate {
    @NotNull(message = "Nội dung câu hỏi không được trống")
    private String dapAn;
    @NotNull(message = "Xác nhận câu trả lời đúng/sai")
    private boolean isTrue;

}
