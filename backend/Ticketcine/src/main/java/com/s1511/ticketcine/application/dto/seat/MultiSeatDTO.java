package com.s1511.ticketcine.application.dto.seat;

import java.util.List;

public record MultiSeatDTO(
        String userId,
        List<String> seatIds)
{
}
