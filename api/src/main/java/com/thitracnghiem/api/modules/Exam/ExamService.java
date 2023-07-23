package com.thitracnghiem.api.modules.Exam;

import com.thitracnghiem.api.base.CRUDBaseServiceImpl;
import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.exam.repos.ExamRepository;
import com.thitracnghiem.api.entities.question.repos.QuestionRepository;
import com.thitracnghiem.api.payload.request.exam.ExamRequest;
import com.thitracnghiem.api.payload.response.exam.ExamResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
@Slf4j
@Transactional
@Service
public class ExamService extends CRUDBaseServiceImpl<Exam, ExamRequest, Exam, Long> {
    private final ExamRepository examRepository;
    private final long expireIn = Duration.ofHours(1).toSeconds();
    public ExamService(ExamRepository examRepository){
        super(Exam.class, ExamRequest.class, Exam.class, examRepository);
        this.examRepository = examRepository;
    }
    @Value("${jwkFile}")
    private Resource jwkFile;

    @Autowired
    QuestionRepository questionRepository;

    public ExamResponse createExam(ExamRequest examRequest) throws IOException {
        Date date = new Date(Instant.now().plusSeconds(expireIn).toEpochMilli());
        Exam exam = Exam.builder()
                .tenDT(examRequest.getTenDT())
                .ngayTao(date)
                .thoiGian(examRequest.getThoiGian()).build();
        examRepository.save(exam);
        return ExamResponse.builder().message("Create Exam Successful").status(true).exam(exam).build();
    }
    public Iterable<Map<String,Object>> getAllExam() {
        return examRepository.findAllAndSum();
    }

    public Optional<Exam> getExamByID(Long id) {
        return examRepository.findById(id);
    }
    public ExamResponse updateExam(Long id,ExamRequest examRequest) throws IOException{
        Optional<Exam> exam = examRepository.findById(id);
        if(exam.isPresent()){
            exam.get().setTenDT(examRequest.getTenDT());
            exam.get().setThoiGian(examRequest.getThoiGian());
            examRepository.save(exam.get());
            return ExamResponse.builder().message("Update Exam Successful").status(true).exam(exam.get()).build();
        }else
            return ExamResponse.builder().message("không tìm thấy đề thi").status(false).exam(exam.get()).build();
    }
}
