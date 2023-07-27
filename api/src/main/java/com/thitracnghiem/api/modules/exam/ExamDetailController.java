package com.thitracnghiem.api.modules.exam;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
}
