package com.thitracnghiem.api.entities.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.question.entities.Answer;
import com.thitracnghiem.api.entities.question.entities.Question;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "testDetail")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TestDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCTBT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idCH")
    private Question question;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idBT")
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAnswer")
    private Answer answer;
}
