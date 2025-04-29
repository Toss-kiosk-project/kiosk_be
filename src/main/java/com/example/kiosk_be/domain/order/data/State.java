package com.example.kiosk_be.domain.order.data;

public enum State {
   READY(0), FINISH(1), END(2);

   private final int value;

   State(int value) {
       this.value = value;
   }
}
