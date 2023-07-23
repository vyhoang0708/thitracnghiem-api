package com.thitracnghiem.api.payload.request.exam;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ExamRequest {
    @NotNull(message = "Tên đề thi không được trống")
    private String tenDT;

    @NotNull(message = "Thời gian làm bài không được để trống")
    private int thoiGian;

}
