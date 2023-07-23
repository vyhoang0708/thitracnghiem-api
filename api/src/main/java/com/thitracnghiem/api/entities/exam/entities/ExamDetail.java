package com.thitracnghiem.api.entities.exam.entities;

import com.thitracnghiem.api.entities.question.entities.Question;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "examDetail")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCTDT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDT")
    private Exam exam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCH")
    private Question question;


}
