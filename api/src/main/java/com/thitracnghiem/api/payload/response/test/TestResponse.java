package com.thitracnghiem.api.payload.response.test;

import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.test.entities.TestDetail;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestResponse {
    private boolean status;
    private int cauDung;
    private Double diem;
    private Test test;
    Iterable<TestDetail> testDetails;
}
