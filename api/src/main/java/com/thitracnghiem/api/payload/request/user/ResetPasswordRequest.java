package com.thitracnghiem.api.payload.request.user;


import lombok.Data;
@Data
public class ResetPasswordRequest {
    private String verifyCode;
    private String password;
}
