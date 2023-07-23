package com.thitracnghiem.api.entities.user.repos;

import com.thitracnghiem.api.entities.user.entities.Account;
import com.thitracnghiem.api.entities.user.entities.ForgotPassword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepository extends CrudRepository<ForgotPassword, Long> {
    ForgotPassword findByVerifyCode(String verifyCode);
    ForgotPassword findForgotPasswordByAccount(Account account);
}
