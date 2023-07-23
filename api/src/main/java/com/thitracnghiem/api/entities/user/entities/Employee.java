package com.thitracnghiem.api.entities.user.entities;
import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "employee")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(255)")
    private String hoTen;

    @Column(unique = true)
    private String sdt;

    @OneToOne(fetch = FetchType.EAGER)
    private Account account;

    private boolean trangThai;
}


