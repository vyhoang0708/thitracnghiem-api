package com.thitracnghiem.api.modules.test;

import com.thitracnghiem.api.base.CRUDBaseServiceImpl;
import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.exam.repos.ExamRepository;
import com.thitracnghiem.api.entities.question.entities.Answer;
import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.entities.question.repos.AnswerRepository;
import com.thitracnghiem.api.entities.question.repos.QuestionRepository;
import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.test.entities.TestDetail;
import com.thitracnghiem.api.entities.test.repos.TestDetailRepository;
import com.thitracnghiem.api.entities.test.repos.TestRepository;
import com.thitracnghiem.api.entities.user.entities.UserInfo;
import com.thitracnghiem.api.entities.user.repos.UserRepository;
import com.thitracnghiem.api.payload.request.test.TestDetailRequest;
import com.thitracnghiem.api.payload.request.test.TestRequest;
import com.thitracnghiem.api.payload.response.exam.ExamResponse;
import com.thitracnghiem.api.payload.response.test.TestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class TestService extends CRUDBaseServiceImpl<Test, TestRequest, Test, Long>{
    private final TestRepository testRepository;
    private final long expireIn = Duration.ofHours(1).toSeconds();
    public TestService(TestRepository testRepository){
        super(Test.class, TestRequest.class, Test.class, testRepository);
        this.testRepository = testRepository;
    }
    @Value("${jwkFile}")
    private Resource jwkFile;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TestDetailRepository testDetailRepository;
     public Iterable<Test> getTestByUser(Long id){
         return testRepository.findByUserInfo_id(id);
     }
    @Transactional
     public TestResponse createTest(TestRequest testRequest) throws IOException {
         boolean result = false;
         Exam exam = examRepository.findById(testRequest.getExam()).get();
         Date date = new Date(Instant.now().plusSeconds(expireIn).toEpochMilli());
         Test test = Test.builder()
                 .exam(exam)
                 .userInfo(userRepository.findById(2L).get())
                 .diem(20)
                 .ngayThi(date)
                 .build();
         testRepository.save(test);
         try {
             for (TestDetailRequest testDetailRequest : testRequest.getTestDetailRequests()){
                 System.out.println(testDetailRequest.getQuestion());
                 TestDetail testDetail = TestDetail.builder()
                         .test(test)
                         .question(questionRepository.findById(testDetailRequest.getQuestion()).get())
                         .answer(answerRepository.findById(testDetailRequest.getAnswer()).get())
                         .build();
                 testDetailRepository.save(testDetail);
             }
             result = true;
         }catch (Exception e){
             System.out.println(e.getMessage());
             System.out.println(e);
             TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
         }

         return TestResponse.builder().message("Create Successful").status(result).test(test).build();
     }
}
