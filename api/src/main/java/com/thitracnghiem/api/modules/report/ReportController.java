package com.thitracnghiem.api.modules.report;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.test.entities.Test;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping("/score/{id}")
    public Mono<Iterable<Test>> getTestByExam(@PathVariable("id") Long id){
        System.out.println("111");
        return Mono.just(reportService.getTestByExam(id));
    }
    @GetMapping("/exams")
    public Mono<Iterable<Map<String,Object>>> getExams(){
        return Mono.just(reportService.getLuotThi());
    }

}
