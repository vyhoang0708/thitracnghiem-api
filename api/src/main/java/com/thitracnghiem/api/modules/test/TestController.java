package com.thitracnghiem.api.modules.test;

import com.thitracnghiem.api.config.PersistenceConfig;
import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.test.entities.TestDetail;
import com.thitracnghiem.api.payload.request.test.TestRequest;
import com.thitracnghiem.api.payload.response.test.TestResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    TestDetailService testDetailService;
    @Autowired
    AuditorAware auditorAware;
    @GetMapping("/user")
    public Mono<Iterable<Test>> getTestByUser(){
        Long userID = Long.parseLong(auditorAware.getCurrentAuditor().get().toString());
        return Mono.just(testService.getTestByUser(userID));
    }
    @PostMapping("/create")
    public Mono<TestResponse> createTest(@RequestBody TestRequest testRequest) throws IOException {
        Long userID = Long.parseLong(auditorAware.getCurrentAuditor().get().toString());
        return Mono.just(testService.createTest(testRequest, userID));
    }
    @GetMapping("/{id}")
    public Mono<Iterable<TestDetail>> getTestDetail(@PathVariable ("id") Long id){
        return Mono.just(testDetailService.getTestDetail(id));
    }

}
