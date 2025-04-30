package com.example.kiosk_be.domain.user.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    private Role role;
    private String password;
    private String userName;
    private boolean hasDelete;
}
