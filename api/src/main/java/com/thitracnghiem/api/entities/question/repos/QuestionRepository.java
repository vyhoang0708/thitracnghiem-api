package com.thitracnghiem.api.entities.question.repos;

import com.thitracnghiem.api.entities.question.entities.Category;
import com.thitracnghiem.api.entities.question.entities.Question;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>, JpaSpecificationExecutor<Question> {
    Optional<Question>  findByCategory_IdCategory(Long id);


    @Query("FROM Question u" +
            " where u.category.idCategory = :id ")
    Iterable<Question> findAllSortCategory(Long id);

}
