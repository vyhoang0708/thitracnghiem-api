package com.thitracnghiem.api.payload.response.user;

import com.thitracnghiem.api.entities.user.entities.UserInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {

    private boolean status;

    private String message;

    private String accessToken;

    private long expiresIn;

    private String refreshToken;

    private UserInfo userInfo;



}
