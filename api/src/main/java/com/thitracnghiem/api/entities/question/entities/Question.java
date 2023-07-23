package com.thitracnghiem.api.entities.question.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "question")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCH;

    @Column(columnDefinition = "nvarchar(255)")
    private String noiDung;

    private int mucDo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "cauHoi")
    @JsonManagedReference
    private List<Answer> answers;
}
