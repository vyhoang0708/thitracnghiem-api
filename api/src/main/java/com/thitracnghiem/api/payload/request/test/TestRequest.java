package com.thitracnghiem.api.payload.request.test;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TestRequest {

    @NotNull(message = "Điểm thi không được trống")
    private float diem;
    private String user;
    private String exam;
}
