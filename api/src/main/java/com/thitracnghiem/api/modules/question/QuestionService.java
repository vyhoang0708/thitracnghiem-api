package com.thitracnghiem.api.modules.question;

import com.thitracnghiem.api.base.CRUDBaseServiceImpl;
import com.thitracnghiem.api.entities.exam.repos.ExamDetailRepository;
import com.thitracnghiem.api.entities.question.entities.Answer;
import com.thitracnghiem.api.entities.question.entities.Category;
import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.entities.question.repos.AnswerRepository;
import com.thitracnghiem.api.entities.question.repos.CategoryRepository;
import com.thitracnghiem.api.entities.question.repos.QuestionRepository;
import com.thitracnghiem.api.payload.request.question.AnswerRequestCreate;
import com.thitracnghiem.api.payload.request.question.AnswerRequestUpdate;
import com.thitracnghiem.api.payload.request.question.QuestionRequestCreate;
import com.thitracnghiem.api.payload.request.question.QuestionRequestUpdate;
import com.thitracnghiem.api.payload.response.question.QuestionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class QuestionService extends CRUDBaseServiceImpl<Question, QuestionRequestCreate, Question, Long> {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository){
        super(Question.class, QuestionRequestCreate.class, Question.class, questionRepository);
        this.questionRepository = questionRepository;
    }
    @Value("${jwkFile}")
    private Resource jwkFile;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    ExamDetailRepository examDetailRepository;
    @Transactional
    public QuestionResponse createQuestion(QuestionRequestCreate questionRequest) throws IOException{
        boolean result = false;
        Category category = categoryRepository.findByTenCategory(questionRequest.getCategory());
        if (category == null)
            return QuestionResponse.builder().message("Category is not exists").status(false).build();
        Question question = Question.builder()
                .noiDung(questionRequest.getNoiDung())
                .mucDo(questionRequest.getMucDo())
                .category(category).build();
        try {
            for (AnswerRequestCreate answerRequest : questionRequest.getAnserList()){
                Answer answer = Answer.builder()
                        .dapAn(answerRequest.getDapAn())
                        .isTrue(answerRequest.isTrue())
                        .cauHoi(question)
                        .build();
                answerRepository.save(answer);
            }
            result = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        questionRepository.save(question);
        return QuestionResponse.builder().message("Create Question Successful").status(result).question(question).build();
    }

    public Iterable<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
    public Optional<Question> getQuestionByID(Long id) {
        return questionRepository.findById(id);
    }
    public Iterable<Question> getQuestionByCategory(long id){
        return questionRepository.findAllSortCategory(id);
    }
    @Transactional
    public QuestionResponse updateQuestion(Long idQuestion, QuestionRequestUpdate questionRequest) throws IOException{
        String message = "";
        Optional<Question> question = questionRepository.findById(idQuestion);
        Iterable<Answer> answers = answerRepository.findAllSortQuestion(idQuestion);
        if(!question.isPresent())
            return QuestionResponse.builder().status(false).message("Cannot find Question").build();
        if(questionRequest.getNoiDung() != null)
            question.get().setNoiDung(questionRequest.getNoiDung());
        if(questionRequest.getMucDo() >0)
            question.get().setMucDo(questionRequest.getMucDo());
        if(questionRequest.getCategory() != null)
            question.get().setCategory(categoryRepository.findByTenCategory(questionRequest.getCategory()));
        List<AnswerRequestUpdate> answersRequests = questionRequest.getAnserList();
        try{
            for (AnswerRequestUpdate answerRequest : answersRequests){
                Optional<Answer> answer = answerRepository.findById(answerRequest.getIdAnswer());
                if(answerRequest.getDapAn() != null)
                    answer.get().setDapAn(answerRequest.getDapAn());
                answer.get().setTrue(answerRequest.isTrue());
                answerRepository.save(answer.get());
            }
        }catch (Exception e){
            message = "Lỗi lưu đáp án " + e.getMessage();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        questionRepository.save(question.get());
        return QuestionResponse.builder().status(true).message("Update Question Successful").question(question.get()).build();
    }
    public QuestionResponse deleteQuestion(Long id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            if (examDetailRepository.findByQuestion_IdCH(question.get().getIdCH()).isPresent())
                return QuestionResponse.builder().status(false).message("Câu hỏi đã có trong đề thi, không thể xóa").build();
            try {
                Iterable<Answer> answers = answerRepository.findAllSortQuestion(id);
                for (Answer answer : answers){
                    answerRepository.delete(answer);
                }
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            questionRepository.delete(question.get());
            return QuestionResponse.builder().status(true).message("Delete Question Successful").question(question.get()).build();
        } else
            return QuestionResponse.builder().status(false).message("Câu hỏi không tồn tại").question(null).build();
    }

}
