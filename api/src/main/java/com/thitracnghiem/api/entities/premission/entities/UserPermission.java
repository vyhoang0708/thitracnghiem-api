package com.thitracnghiem.api.entities.premission.entities;

import com.thitracnghiem.api.entities.user.entities.Account;

import javax.persistence.*;

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
    @JoinColumn(name = "idPermission")
    private Account account;
}
