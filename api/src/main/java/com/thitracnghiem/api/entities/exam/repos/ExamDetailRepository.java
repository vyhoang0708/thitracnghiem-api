package com.thitracnghiem.api.entities.exam.repos;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ExamDetailRepository extends CrudRepository<ExamDetail, Long>, JpaSpecificationExecutor<ExamDetail> {
    Optional<ExamDetail> findByQuestion_IdCH(Long id);
    Iterable<ExamDetail> findAllByExam_IdDT(Long id);
}
