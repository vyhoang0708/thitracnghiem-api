package com.thitracnghiem.api.payload.request.test;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class TestRequest {

    private long exam;
    private List<TestDetailRequest> testDetailRequests;
}
