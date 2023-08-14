package com.thitracnghiem.api.modules.test;

import com.thitracnghiem.api.entities.test.entities.TestDetail;
import com.thitracnghiem.api.entities.test.repos.TestDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Transactional
@Service
public class TestDetailService {
    @Autowired
    TestDetailRepository testDetailRepository;
    public Iterable<TestDetail> getTestDetail(Long id) {
        return testDetailRepository.findAllByTest_IdBT(id);
    }

}
