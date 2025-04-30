package com.example.kiosk_be.domain.user.data;

public enum Role {
    ADMIN(0), USER(1);

    private final int value;

    Role(int value) {
        this.value = value;
    }
}
