package com.example.kiosk_be.domain.user.repository;

import com.example.kiosk_be.domain.user.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
