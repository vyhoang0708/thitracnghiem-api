package com.thitracnghiem.api.entities.test.repos;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.user.entities.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
    Optional<Test> findByExam_idDT(Long id);
    Iterable<Test> findByUserInfo_id(Long id);
}
