package com.thitracnghiem.api.entities.exam.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "exam")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDT;

    @Column(columnDefinition = "nvarchar(255)")
    private String tenDT;

    private Date ngayTao;

    private int thoiGian;
}
