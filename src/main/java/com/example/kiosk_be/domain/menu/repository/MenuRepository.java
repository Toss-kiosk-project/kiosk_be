package com.example.kiosk_be.domain.menu.repository;

import com.example.kiosk_be.domain.menu.data.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {
}
