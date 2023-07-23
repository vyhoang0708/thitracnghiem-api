package com.thitracnghiem.api.entities.question.entities;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(columnDefinition = "nvarchar(255)")
    private String tenCategory;
}
