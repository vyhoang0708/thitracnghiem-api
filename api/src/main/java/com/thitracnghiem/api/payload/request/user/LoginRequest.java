package com.thitracnghiem.api.payload.request.user;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

}
