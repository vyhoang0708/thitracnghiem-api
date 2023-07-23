package com.thitracnghiem.api.entities.test.entities;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.question.entities.Answer;
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
    @JoinColumn(name = "idDT")
    private Exam exam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBT")
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAnswer")
    private Answer answer;
}
