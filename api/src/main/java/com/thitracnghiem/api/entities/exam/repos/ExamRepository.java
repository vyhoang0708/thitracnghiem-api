package com.thitracnghiem.api.entities.exam.repos;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface ExamRepository extends CrudRepository<Exam, Long>, JpaSpecificationExecutor<Exam> {
    @Query( value =
            "select u.iddt, tenDT as ten,count(ex.idCTDT) as soluong, thoi_Gian, ngay_tao from Exam u" +
            " left join exam_Detail ex on u.idDT=ex.idDT" +
                    " group by u.iddt,tenDT, thoi_Gian, ngay_tao",nativeQuery = true)
    Iterable<Map<String,Object>>findAllAndCount();
}
