package com.thitracnghiem.api.modules.test;

import com.thitracnghiem.api.entities.test.repos.TestDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class TestDetailService {
    @Autowired
    TestDetailRepository testDetailRepository;

}
