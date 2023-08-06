package com.thitracnghiem.api.entities.premission.entities;

import com.thitracnghiem.api.entities.user.entities.Account;
import lombok.*;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@Table(name = "userPermission")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idScreen")
    private Screen screen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPermission")
    private Permission permission;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private Account account;
}
