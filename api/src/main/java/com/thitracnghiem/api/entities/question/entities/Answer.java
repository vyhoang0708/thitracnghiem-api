package com.thitracnghiem.api.entities.question.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "answer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnswer;

    @Column(columnDefinition = "nvarchar(255)")
    private String dapAn;

    private boolean isTrue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Question cauHoi;
}
