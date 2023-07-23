package com.thitracnghiem.api.modules.question;

import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.payload.request.question.QuestionRequestCreate;
import com.thitracnghiem.api.payload.request.question.QuestionRequestUpdate;
import com.thitracnghiem.api.payload.response.question.QuestionResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/all")
    public Mono<Iterable<Question>> getAllQuestion(){
        return Mono.just(questionService.getAllQuestion());
    }
    @GetMapping("/byCategory/{id}")
    public Mono<Iterable<Question>> getByCategory(long idCategory){
        return Mono.just(questionService.getQuestionByCategory(idCategory));
    }
    @GetMapping("/{id}")
    public Mono<Optional<Question>> getById(@PathVariable ("id") Long id){
        return Mono.just(questionService.getQuestionByID(id));
    }
    @PostMapping("/create")
    public Mono<QuestionResponse> createQuestion(@RequestBody QuestionRequestCreate questionRequest)throws IOException{
        return Mono.just(questionService.createQuestion(questionRequest));
    }
    @PutMapping ("/update/{id}")
    public Mono<QuestionResponse> updateQuestion(@RequestBody QuestionRequestUpdate questionReques,
                                                 @PathVariable Long id) throws IOException{
        return Mono.just(questionService.updateQuestion(id,questionReques));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<QuestionResponse> deleteQuestion(@PathVariable Long id){
        return Mono.just(questionService.deleteQuestion(id));
    }
}
