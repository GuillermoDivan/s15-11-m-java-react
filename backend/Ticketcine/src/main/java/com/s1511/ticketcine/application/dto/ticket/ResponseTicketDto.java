package com.s1511.ticketcine.application.dto.ticket;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseTicketDto(
        String id,
        String userId,
        String cinemaName,
        String screenId,
        String movieName,
        List<String> seatsIds,
        LocalDateTime functionDate,
        Double value,
        Boolean active
) {
}