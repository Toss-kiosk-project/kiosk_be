package com.example.kiosk_be.domain.user.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    private Role role;
    private String password;
    private String userName;
    private boolean hasDelete;
}
