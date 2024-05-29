package com.s1511.Ticketcine.application.dto.comment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReadDtoComment(
        String id,
        String userId,
        String movieId,
        String comment,
        LocalDateTime date
) {
}
