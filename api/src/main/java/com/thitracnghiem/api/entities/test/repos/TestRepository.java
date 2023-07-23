package com.thitracnghiem.api.entities.test.repos;

import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.user.entities.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
}
