package com.thitracnghiem.api.payload.response.question;

import com.thitracnghiem.api.entities.question.entities.Answer;
import com.thitracnghiem.api.entities.question.entities.Question;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class QuestionResponse {
    private boolean status;
    private String message;
    private Question question;

    private Iterable<Answer> answers;
}
