package com.thitracnghiem.api.payload.request.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserRequest {
    private String userName;
    private String hoTen;

    @NotNull(message = "Email không được trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Phone không được trống")
    @NotNull
    private String sdt;

    private String roleName;
    private String password;
}
