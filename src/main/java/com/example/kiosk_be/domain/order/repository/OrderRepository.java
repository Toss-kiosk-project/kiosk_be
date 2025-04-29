package com.example.kiosk_be.domain.order.repository;

import com.example.kiosk_be.domain.order.data.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Query("SELECT MAX(o.code) FROM OrderEntity o")
    Optional<Integer> findMaxCode();
}
