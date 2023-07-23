package com.thitracnghiem.api.payload.request.question;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryRequest {
    @NotNull(message = "Tên loại câu hỏi không được trống")
    private String tenLoai;
}
