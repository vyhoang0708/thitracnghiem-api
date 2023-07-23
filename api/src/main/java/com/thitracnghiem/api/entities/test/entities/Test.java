package com.thitracnghiem.api.entities.test.entities;

import com.thitracnghiem.api.entities.exam.entities.Exam;
import com.thitracnghiem.api.entities.question.entities.Question;
import com.thitracnghiem.api.entities.user.entities.UserInfo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "test")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDT")
    private com.thitracnghiem.api.entities.exam.entities.Exam Exam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private UserInfo userInfo;


    private Date ngayThi;


    private float diem;
}
