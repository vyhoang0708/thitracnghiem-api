package com.thitracnghiem.api.entities.test.repos;

import com.thitracnghiem.api.entities.exam.entities.ExamDetail;
import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.user.entities.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
    Iterable<Test> findByUserInfo_id(Long id);
    List<Test> findByExam_idDT(Long id);
    @Query( value =
            "select  ex.tenDT as ten,count(u.idUser) as luotThi from Exam ex " +
                    " left join Test u on u.idDT=ex.idDT" +
                    " group by tenDT",nativeQuery = true)
    Iterable<Map<String,Object>>findAllAndCount();
}
