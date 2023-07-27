package com.thitracnghiem.api.modules.exam;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.payload.request.exam.ExamRequest;
import com.thitracnghiem.api.payload.response.exam.ExamResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/exam")
public class ExamController {
    @Autowired
    ExamService examService;
    @GetMapping("/all")
    public Mono<Iterable<Map<String,Object>>> getAllExam(){
        return Mono.just(examService.getAllExam());
    }
    @GetMapping("/{id}")
    public Mono<Optional<Exam>> getExamByID(@PathVariable("id") Long ID) {
        return Mono.just(examService.getExamByID(ID));
    }

    @PostMapping("/create")
    public Mono<ExamResponse> createExam(@RequestBody ExamRequest examRequest)throws IOException{
        return Mono.just(examService.createExam(examRequest));
    }
    @PutMapping ("/update/{id}")
    public Mono<ExamResponse> updateExam(@RequestBody ExamRequest examRequest,
                                         @PathVariable Long id) throws IOException{
        return Mono.just(examService.updateExam(id,examRequest));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ExamResponse> deleteExam(@PathVariable Long id){
        return Mono.just(examService.deleteExam(id));
    }
}
