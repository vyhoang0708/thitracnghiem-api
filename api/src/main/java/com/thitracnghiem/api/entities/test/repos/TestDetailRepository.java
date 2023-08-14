package com.thitracnghiem.api.entities.test.repos;

import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.entities.test.entities.TestDetail;
import com.thitracnghiem.api.entities.user.entities.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;
import java.util.Map;
@Repository
public interface TestDetailRepository extends CrudRepository<TestDetail, Long>, JpaSpecificationExecutor<TestDetail> {
    Iterable<TestDetail> findAllByTest_IdBT(Long id);

}
