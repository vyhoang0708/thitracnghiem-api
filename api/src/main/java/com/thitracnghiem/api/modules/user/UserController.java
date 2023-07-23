package com.thitracnghiem.api.modules.user;


import com.thitracnghiem.api.payload.response.user.UserResponse;
import com.thitracnghiem.common.http.ApiResponse;
import com.thitracnghiem.api.entities.user.entities.UserInfo;
import com.thitracnghiem.api.security.jwt.CustomAuthUser;
import com.thitracnghiem.api.security.jwt.JWTAuthenticationToken;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public Mono<UserResponse> getUserCurrent(Principal principal) {
        JWTAuthenticationToken jwtTokenObject = (JWTAuthenticationToken) principal;
            return Mono.just(userService.getUserProfile(Long.parseLong(((CustomAuthUser) jwtTokenObject.getPrincipal()).getUserId())));
    }

    @DeleteMapping("")
    public Mono<ApiResponse<?>> blockUserCurrent(Principal principal) {
            JWTAuthenticationToken jwtTokenObject = (JWTAuthenticationToken) principal;
            return Mono.just(userService.deleteAccountUser(Long.parseLong(((CustomAuthUser) jwtTokenObject.getPrincipal()).getUserId())));

    }

    @GetMapping("/all")
    public Iterable<UserInfo> getUsers(){
        return userService.getAllUser();
    }


}
