package com.thitracnghiem.api.modules.test;

import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.payload.request.test.TestRequest;
import com.thitracnghiem.api.payload.response.test.TestResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping("/{id}")
    public Mono<Iterable<Test>> getTestByUser(@PathVariable("id") Long id){
        return Mono.just(testService.getTestByUser(id));
    }
    @PostMapping("/create")
    public Mono<TestResponse> createTest(@RequestBody TestRequest testRequest) throws IOException {
        return Mono.just(testService.createTest(testRequest));
    }
}
