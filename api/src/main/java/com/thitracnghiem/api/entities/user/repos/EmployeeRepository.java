package com.thitracnghiem.api.entities.user.repos;

import com.thitracnghiem.api.entities.user.entities.Account;
import com.thitracnghiem.api.entities.user.entities.Employee;
import com.thitracnghiem.api.entities.user.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {



}
