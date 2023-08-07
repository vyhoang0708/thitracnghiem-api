package com.thitracnghiem.api.modules.report;

import com.thitracnghiem.api.entities.test.entities.Test;
import com.thitracnghiem.api.entities.test.repos.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
@Service
public class ReportService {
    @Autowired
    TestRepository testRepository;
    public List<Test> getTestByExam(Long id){
        System.out.println("oke");
        return testRepository.findByExam_idDT(id);
    }
    public Iterable<Map<String,Object>> getLuotThi() {return testRepository.findAllAndCount();}
}
