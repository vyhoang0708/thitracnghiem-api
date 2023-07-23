package com.thitracnghiem.api.entities.user.entities;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "account")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique=true)
    private String username;

    @NonNull
    private String password;

    @Column(unique = true)
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Role role;

    private  boolean deleteFlag;
}
