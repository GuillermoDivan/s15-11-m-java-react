package com.s1511.ticketcine.application.dto.comment;
import jakarta.validation.constraints.NotNull;

public record CreateDtoComment(
        @NotNull(message = "El userId no puede ser nulo")
        String userId,
        @NotNull(message = "El movieId no puede ser nulo")
        String movieId,
        @NotNull(message = "El comentario no puede ser nulo")
        String comment
) {
}
