package com.s1511.ticketcine.application.dto.seat;

public record SeatDTO(
        Long id,
        String seatNumber,
        boolean reserved) {}
