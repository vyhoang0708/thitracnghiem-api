package com.thitracnghiem.api.modules.exam;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import com.thitracnghiem.api.payload.request.exam.ExamDetailRequest;
import com.thitracnghiem.api.payload.response.exam.ExamDetailResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/examDetail")
public class ExamDetailController {
    @Autowired
    ExamDetailService examDetailService;
    @GetMapping("/{id}")
    public Mono<Iterable<ExamDetail>> getExamDetailByExam(@PathVariable ("id") Long id){
        return Mono.just(examDetailService.getAllExamDetailByExam(id));
    }
    @PostMapping("/addQuestion")
    public Mono<ExamDetailResponse> addQuestion(@RequestBody ExamDetailRequest examDetailRequest) throws IOException{
        return Mono.just(examDetailService.addQuestion(examDetailRequest));
    }
}
