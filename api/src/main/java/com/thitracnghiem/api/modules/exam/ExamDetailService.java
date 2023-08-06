package com.thitracnghiem.api.modules.exam;

import com.thitracnghiem.api.base.CRUDBaseServiceImpl;
import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import com.thitracnghiem.api.entities.exam.repos.ExamDetailRepository;
import com.thitracnghiem.api.entities.exam.repos.ExamRepository;
import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.entities.question.repos.QuestionRepository;
import com.thitracnghiem.api.payload.request.exam.AddQuestionRequest;
import com.thitracnghiem.api.payload.request.exam.ExamDetailRequest;
import com.thitracnghiem.api.payload.response.exam.ExamDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class ExamDetailService extends CRUDBaseServiceImpl<ExamDetail,ExamDetailRequest, ExamDetail,Long> {
    private final ExamDetailRepository examDetailRepository;
    public ExamDetailService(ExamDetailRepository examDetailRepository){
        super(ExamDetail.class, ExamDetailRequest.class, ExamDetail.class, examDetailRepository);
        this.examDetailRepository = examDetailRepository;
    }
    @Value("${jwkFile}")
    private Resource jwkFile;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;
    public Iterable<ExamDetail> getAllExamDetailByExam(Long id) {
        return examDetailRepository.findAllByExam_IdDT(id);
    }
    @Transactional
    public ExamDetailResponse addQuestion(ExamDetailRequest examDetailRequest){
        Exam exam = examRepository.findById(examDetailRequest.getIdExam()).get();
        if (exam == null){
            return ExamDetailResponse.builder().message("Exam is not exists").status(false).build();
        }
        try{
            for (AddQuestionRequest questionRequest : examDetailRequest.getAddQuestionRequests()){
                Question question = questionRepository.findById(questionRequest.getIdCH()).get();
                if (question == null){
                    return ExamDetailResponse.builder().message("Question is not exists").status(false).build();
                }
                ExamDetail examDetail = ExamDetail.builder()
                        .exam(exam)
                        .question(question)
                        .build();
                examDetailRepository.save(examDetail);
            }
        }catch (Exception e){
            return ExamDetailResponse.builder().message("Lỗi không thêm được").status(false).build();
        }

        return ExamDetailResponse.builder().message("Add Question Successful").status(true).build();
    }

}
