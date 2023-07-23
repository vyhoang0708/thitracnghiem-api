package com.thitracnghiem.api.payload.request.question;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class QuestionRequestUpdate {
    @NotNull(message = "Nội dung câu hỏi không được trống")
    private String noiDung;

    private int mucDo;
    private String category;

    private List<AnswerRequestUpdate> anserList;
}
