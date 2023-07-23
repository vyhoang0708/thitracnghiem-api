package com.thitracnghiem.api.modules.Exam;

import com.thitracnghiem.api.base.CRUDBaseServiceImpl;
import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import com.thitracnghiem.api.entities.exam.repos.ExamDetailRepository;
import com.thitracnghiem.api.payload.request.exam.ExamDetailRequest;
import lombok.extern.slf4j.Slf4j;
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
    public Iterable<ExamDetail> getAllExamDetailByExam(Long id) {
        return examDetailRepository.findAllByExam_IdDT(id);
    }
}
