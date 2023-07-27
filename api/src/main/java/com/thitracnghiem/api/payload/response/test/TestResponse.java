package com.thitracnghiem.api.payload.response.test;

import com.thitracnghiem.api.entities.test.entities.Test;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestResponse {
    private boolean status;
    private String message;
    private Test test;
}
