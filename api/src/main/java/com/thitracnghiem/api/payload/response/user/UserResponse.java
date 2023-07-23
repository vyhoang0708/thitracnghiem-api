package com.thitracnghiem.api.payload.response.user;

import com.thitracnghiem.api.entities.user.entities.Role;
import com.thitracnghiem.api.entities.user.entities.UserInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private boolean status;
    private String message;
    private UserInfo userInfo;
    private Role role;
}
