package com.thitracnghiem.api.entities.question.repos;

import com.thitracnghiem.api.entities.question.entities.Answer;
import com.thitracnghiem.api.entities.question.entities.Question;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>, JpaSpecificationExecutor<Answer> {
    @Query("FROM Answer u" +
            " where u.cauHoi.idCH = :id ")
    Iterable<Answer> findAllSortQuestion(Long id);
}
