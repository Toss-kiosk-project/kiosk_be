package com.example.kiosk_be.domain.menu.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class MenuEntity {
    @Id
    private UUID id;
    private String name;
    private String category;
    private int price;
    private String img;
    private boolean hasDelete;
}
