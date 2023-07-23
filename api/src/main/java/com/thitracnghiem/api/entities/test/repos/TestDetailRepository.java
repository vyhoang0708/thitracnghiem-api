package com.thitracnghiem.api.entities.test.repos;

import com.thitracnghiem.api.entities.test.entities.TestDetail;
import com.thitracnghiem.api.entities.user.entities.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestDetailRepository extends CrudRepository<TestDetail, Long>, JpaSpecificationExecutor<TestDetail> {
}
