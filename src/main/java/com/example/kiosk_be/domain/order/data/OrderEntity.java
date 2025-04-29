package com.example.kiosk_be.domain.order.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OrderEntity {
    @Id
    private UUID id;
    private State state;
    private int totalPrice;
    private int code;
    private LocalDateTime orderTime;
    private UUID userId;
    private int menuNum;

    public void updateState(State state){
        this.state = state;
    }
}

